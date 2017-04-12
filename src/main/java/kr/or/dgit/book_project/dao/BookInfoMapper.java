package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.book_project.dto.BookInfo;


public interface BookInfoMapper {
	int insertBookInfo(BookInfo bookInfo); // 도서 추가

	int updateBookInfo(BookInfo bookInfo); // 도서 정보 수정
	int setDelBookInfo(BookInfo bookInfo); // 도서 폐기/복원
	
	BookInfo selectBookInfoOne(Map<String, Object> param);
	BookInfo selectOnlyBookInfo(BookInfo bookInfo);

	int countBookInfo(Map<String, Object> param);

	List<BookInfo> selectBookInfo(Map<String, Object> param); // 
	

	//////////////////////////////
	
	List<BookInfo> selectAllBookInfo(Map<String, Object> param);

	//대여 테이블 
	List<BookInfo> selectIslending(Map<String, Object> param);
	
	//그래프용
	/*List<BookInfo> selectAllCountBookInfo();
	List<BookInfo> subCountBookInfo();
	List<BookInfo> blackCountBookInfo();
	List<BookInfo> lendCountBookInfo();*/
	/*List<Map<String,Object>> selectAllGroupByConame();*/
	List<Map<String,Object>> selectAllCountBookInfo();
	List<BookInfo> subCountBookInfo(int subBookSize);
	List<BookInfo> blackCountBookInfo(int blackCountBookSize);
	List<BookInfo> lendCountBookInfo(int lendCountBookSize);

	
}
