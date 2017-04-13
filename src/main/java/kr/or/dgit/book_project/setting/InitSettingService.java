package kr.or.dgit.book_project.setting;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


import kr.or.dgit.book_project.setting.DaoSet;
import kr.or.dgit.book_project.setting.ConFig;


public class InitSettingService {
	public void initSetting(int onGoing, int init) {

		DaoSet dao = DaoSet.getInstance();
		try {
			if (init == 1) {// 초기화 (X,1)
				dao.getUpdateResult("drop database if exists " + ConFig.DB_NAME);
				dao.getUpdateResult("create  database if not exists " + ConFig.DB_NAME);
				dao.getUpdateResult("use " + ConFig.DB_NAME);
				
				for (int i = 0; i < ConFig.CREATE_SQL_TABLE.length; i++) {
					dao.getUpdateResult(ConFig.CREATE_SQL_TABLE[i]);
					System.err.println(ConFig.TABLE_NAME[i] + "Table 생성완료");
				}
				
				for (int i = 0; i < ConFig.CREATE_SQL_PROCEDURE.length; i++) {
					dao.getUpdateResult(ConFig.CREATE_SQL_PROCEDURE[i]);
					System.err.println(ConFig.PROCEDURE_NAMES[i] + "프로시저 생성");
				}
				createIndex();
				if (onGoing == 1) {// 복원 (1,1)
					for (int i = 0; i < ConFig.TABLE_NAME.length; i++) {
						loadTableData(i); // BackupFiles폴더에 있는 파일들을 가져와 테이블에 삽입
					}
					JOptionPane.showMessageDialog(null, "복원 완료");
				}
				if (onGoing == 0 && init == 1) { // 초기화 (0,1)
					JOptionPane.showMessageDialog(null, "초기화 완료");
				}
			} else { // (X,0) 백업
				File file = new File(ConFig.EXPORT_IMPORT_DIR);// 현재 작업하고 있는
																// 프로젝트 경로안의
																// BackupFiles폴더
				File[] fies = file.listFiles(); // BackupFiles 안에 있는 파일들을 배열에 넣음

				if (file.exists() == false) { // 폴더 존재여부
					file.mkdir(); // 없다면 폴더생성
				}
				try { // BackupFiles 안에 파일이 하나도 없는지 체크
					for (File f : fies) { // BackupFiles 안에 있는 파일들을 하나씩 검사
						if (f.exists()) { // 안에 파일이 존재한다면
							f.delete(); // 파일을 지움
						}
					}
				} catch (NullPointerException e) {
				} finally {
					for (int i = 0; i < ConFig.CREATE_SQL_TABLE.length; i++) {
						BackupTableData(i); // BackupFiles에 있는 파일안의 데이터를 가져와
											// DB테이블에 삽입
					}
					JOptionPane.showMessageDialog(null, "백업 완료");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadTableData(int tables) {// 파일 복원
		File file = new File(ConFig.EXPORT_IMPORT_DIR + ConFig.TABLE_NAME[tables]);
		String sql = "load data local infile '%s' " + "into table " + ConFig.TABLE_NAME[tables] + " "
				+ "character set 'UTF8' " + "fields terminated by ',' " + "lines terminated by '\r\n'";

		executeImportData(String.format(sql, file.getAbsolutePath().replace("\\", "/")), file.getName());
	}

	public void BackupTableData(int tables) {// 파일 백업

		String sql = "select * from " + ConFig.TABLE_NAME[tables];
		Connection con = DBCon.getConnection(ConFig.URL + ConFig.DB_NAME, ConFig.USER, ConFig.PWD);
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
			StringBuilder sb = new StringBuilder();
			int colCnt = rs.getMetaData().getColumnCount();
			// 받아온 데이터 컬럼갯수
			while (rs.next()) {
				for (int i = 1; i <= colCnt; i++) {
					Object obj = rs.getObject(i);
					if (obj.equals(true)) {
						// 테이블 안에 값이 있을떄
						obj = 1;
					} else if (obj.equals(false)) {
						// 테이블 안에 값이 null
						obj = 0;
					}
					sb.append(obj + ","); // 1,   // 0, 
				}
				sb.replace(sb.length() - 1, sb.length(), ""); // 1   // 0
				sb.append("\r\n"); // 줄바꿈
			}
			System.out.println(sb.toString());

			try (BufferedOutputStream bw = new BufferedOutputStream(
					new FileOutputStream(ConFig.EXPORT_IMPORT_DIR + ConFig.TABLE_NAME[tables]));
					OutputStreamWriter osw = new OutputStreamWriter(bw, "UTF-8")) {
				osw.write(sb.toString());

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void executeImportData(String sql, String tableName) {
		Statement stmt = null;
		try {
			Connection con = DBCon.getConnection(ConFig.URL + ConFig.DB_NAME, ConFig.USER, ConFig.PWD);
			stmt = con.createStatement();
			stmt.execute(sql);
			System.out.println(sql);
			System.out.printf("Import Table(%s) %d Rows Success! %n", tableName, stmt.getUpdateCount());
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				System.err.println("중복데이터 존재");
			}
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
		}
	}
	private void createIndex() {
		System.out.printf("Index 생성 중 ~~!%n");
		for (int i = 0; i < ConFig.CREATE_INDEX.length; i++) {
			try {
				DaoSet.getInstance().getUpdateResult(ConFig.CREATE_INDEX[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		System.out.printf("Index 생성 완료 ~~!%n");
	}
}