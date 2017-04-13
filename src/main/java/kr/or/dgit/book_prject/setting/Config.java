package kr.or.dgit.book_prject.setting;

public class Config {
	public static final String DB_NAME = "book_project";
	public static final String USER = "root";
	public static final String PWD = "rootroot";
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String DRIVER = "com.mysql.jdbc.Driver";

	public static final String[] TABLE_NAME = { "memberInfo", "publisherInfo", "coden", "bookInfo", "paymentIO"};
	//public static final String IMPORT_DIR = System.getProperty("user.dir") + "\\DataFiles\\";

	public static final String[] CREATE_SQL_TABLE = {
			/*회원*/
			"CREATE TABLE memberInfo (	"
			+ "m_code       CHAR(4)     NOT NULL, 	"
			+ "m_pass       char(41)	 NULL,     	"
			+ "m_name       VARCHAR(20) NULL,     "
			+ "	m_tel        CHAR(13)    NULL,     	"
			+ "m_zip_code   CHAR(5)  NULL,     	"
			+ "m_address    VARCHAR(50) NULL,     	"
			+ "is_posbl     BOOLEAN     NULL     DEFAULT true, 	"
			+ "delay_count  INTEGER     NULL     DEFAULT 0, 	"
			+ "m_lend_count INTEGER     NULL     DEFAULT 0, 	"
			+ "m_now_count  INTEGER     NULL     DEFAULT 0, 	"
			+ "black_date   DATE        NULL     DEFAULT null, 	"
			+ "m_group      CHAR(1)     NULL,     	"
			+ "is_secsn     BOOLEAN     NULL     DEFAULT false, 	"
			+ "m_Add_Detail varchar(50) NULL, "
			+ "PRIMARY KEY (m_code))"			
			,
			/* 출판사 */
			"CREATE TABLE publisherInfo (	" 
			+ "p_code     CHAR(4)     NOT NULL, 	"
			+ "publisher  VARCHAR(50) NULL,     	" 
			+ "p_name     VARCHAR(20) NULL,     	"
			+ "p_tel      VARCHAR(13) NULL,     	" 
			+ "p_zip_code CHAR(5)  NULL,     	"
			+ "p_address  VARCHAR(50) null,      	" 
			+ "p_Add_Detail varchar(50) null, "
			+ "PRIMARY KEY (p_code))"
			,
			/* 도서분류 */
			"CREATE TABLE coden (	" 
			+ "c_name VARCHAR(50) NOT NULL, 	"
			+ "c_code CHAR(2)     NOT null,  	" 
			+ "PRIMARY KEY (c_name ))"
			,
			/* 도서관리 */
			"CREATE TABLE bookInfo (	"
			+ "b_code       CHAR(4)     NOT NULL, 	"
			+ "b_sub_code   INTEGER(2)  NOT NULL, 	"
			+ "c_name       VARCHAR(50) NULL,    	"
			+ "b_name       VARCHAR(20) NULL,     	"
			+ "author       VARCHAR(20) NULL,     	"
			+ "p_code       CHAR(4)     NULL,     	"
			+ "price        INTEGER     NULL,     	 "
			+ "insert_date  DATE        NULL,      "
			+ "b_lend_count INTEGER     NULL     DEFAULT 0, 	"
			+ "is_lending   BOOLEAN     NULL     DEFAULT false, 	"
			+ "is_del       BOOLEAN     NULL     DEFAULT false, 	"
			+ "PRIMARY KEY (b_code, b_sub_code),	"
			+ "FOREIGN KEY (p_code) REFERENCES publisherInfo (p_code) ON UPDATE cascade,	"
			+ "FOREIGN KEY (c_name) references coden ( c_name) ON UPDATE CASCADE)"
			,
			/* 출납 */
			"CREATE TABLE paymentIO (	" 
			+ "no          INTEGER    NOT null AUTO_INCREMENT, 	"
			+ "b_code      CHAR(4)    NOT NULL, 	" 
			+ "b_sub_code  INTEGER(2) NULL,     	"
			+ "m_code      CHAR(4)    NOT NULL, 	" 
			+ "lend_date   DATE       NULL,     	"
			+ "return_date DATE       NULL     DEFAULT null, 	" 
			+ "PRIMARY KEY (no),	"
			+ "FOREIGN KEY (b_code, b_sub_code) REFERENCES bookInfo (b_code, b_sub_code) ON UPDATE cascade,	"
			+ "FOREIGN KEY (m_code) REFERENCES memberInfo (m_code) ON UPDATE CASCADE)"
			
			/*"create table if not exists post(	"
			+ "zipcode	char(5)	null,	"
			+ "sido	varchar(20)	null,	"
			+ "sigungu	varchar(20) null,	"
			+ "doro	varchar(20) null,	"
			+ "building1 int(5) null,	"
			+ "building2 int(5) null)"*/
			};
	

	public static final String[] PROCEDURE_NAMES = { "proc_paymentIO_insert", "proc_paymentIO_update",
			"proc_memberinfo_is_posbl_update" };

	public static final String[] CREATE_SQL_PROCEDURE = {
			"create procedure proc_paymentIO_insert(	"
			+ "in _b_code char(4),	"
			+ "in _b_sub_code int(2),	"
			+ "in _m_code char(4))"
			+ "begin 	"
			+ "declare _m_now_count int;	"
			+ "declare err int default 0;	"
			+ "declare continue handler for sqlexception set err = -1;			"
			+ "start transaction;		"
			+ "UPDATE bookinfo SET  b_lend_count=(b_lend_count+1), is_lending=true WHERE b_code=_b_code and b_sub_code = _b_sub_code;	"
			+ "UPDATE memberinfo SET  m_lend_count=(m_lend_count+1), m_now_count=(m_now_count+1) WHERE m_code=_m_code;		"
			+ "INSERT INTO paymentIO (b_code, b_sub_code, m_code, lend_date, return_date) VALUES(_b_code, _b_sub_code, _m_code, current_date, null);	"
			+ "select m_now_count into _m_now_count from memberinfo where m_code = _m_code;			"
			+ "if _m_now_count > 4 then		"
			+ "update memberinfo set is_posbl = false where m_code = _m_code;	"
			+ "end if;		"
			+ "if err < 0 then		"
			+ "rollback;	"
			+ "else		"
			+ "commit;	"
			+ "end if;	"
			+ "end "
			,
			"CREATE PROCEDURE proc_paymentIO_update(   "
			+ "in _b_code char(4),   "
			+ "in _b_sub_code int(4),   "
			+ "in _m_code char(4),   "
			+ "in _return_date date)"
			+ "begin      "
			+ "declare _delay_count int ;   "
			+ "declare _m_now_count int ;   "
			+ "declare _lend_date date;   "
			+ "declare _black date;   "
			+ "declare err int default 0;   "
			+ "declare continue handler for sqlexception set err = -1;      "
			+ "start transaction;  "
			+ "select lend_date into _lend_date from paymentio where b_code = _b_code  and b_sub_code = _b_sub_code and m_code= _m_code and return_date is null;   "
			+ "UPDATE paymentIO SET return_date = _return_date    where b_code = _b_code and b_sub_code = _b_sub_code and m_code= _m_code and return_date is null;         "
			+ "UPDATE bookinfo SET is_lending = false WHERE b_code= _b_code and b_sub_code = _b_sub_code;   "
			+ "update memberinfo set m_now_count=(m_now_count-1) where m_code = _m_code;         "
			+ "if datediff(_return_date, _lend_date)>2 then       "
			+ "update memberinfo set delay_count = (delay_count+1) where m_code=_m_code;   "
			+ "end if;      "
			+ "select delay_count into _delay_count from memberinfo where m_code=_m_code;      "
			+ "select m_now_count into _m_now_count from memberinfo where m_code=_m_code;      "
			+ "if _delay_count > 2 then            "
			+ "if _m_now_count = 0 then             "
			+ "select max(return_date) into _black from paymentio where m_code = _m_code;      "
			+ "update memberinfo set black_date = date_add(_black , INTERVAL 30 DAY) where m_code=_m_code;   "
			+ "end if;    "
			+ "end if;     "
			+ "if err < 0 then      "
			+ "rollback;   "
			+ "else      "
			+ "commit;   "
			+ "end if;   "
			+ "end"
			,
			"create procedure proc_memberinfo_is_posbl_update(	"
			+ "in _m_code char(4))"
			+ "begin 	"
			+ "declare datecnt int;	"
			+ "declare err int default 0;	"
			+ "declare continue handler for sqlexception set err = -1;		"
			+ "start transaction;			"
			+ "select datediff(current_date, DATE_ADD(lend_date, interval 2 day)) into datecnt from paymentio	where return_date is null and m_code = _m_code limit 0,1;	"
			+ "if datecnt > 0 then	 	"
			+ "update memberinfo set is_posbl = false where m_code = _m_code;	"
			+ "end if;			"
			+ "select black_date into @_black from memberinfo where m_code = _m_code;	"
			+ "if @_black is not null then		"
			+ "if @_black < current_date then			"
			+ "update memberinfo set is_posbl = true, black_date = null, delay_count = 0 where m_code = _m_code;		"
			+ "end if;	"
			+ "end if;		"
			+ "if err < 0 then		"
			+ "rollback;	"
			+ "else		"
			+ "commit;	"
			+ "end if;	"
			+ "end "
	};

	public static final String CRATE_USER = 
			String.format("grant select, insert, update on %s.* to '%s' identified by '%s'", 
			DB_NAME, 
			USER, 
			PWD);

	public static final String[] CREATE_INDEX={
	  "CREATE INDEX idx_post_sido On post(sido)",
	  "CREATE INDEX idx_post_doro ON post(doro)"};
	public static final String EXPORT_IMPORT_DIR = System.getProperty("user.dir")+ "\\BackupFiles\\"; 
}
