package kr.or.dgit.book_project.setting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoSet {
	private static DaoSet instance = new DaoSet();

	private DaoSet() {}
	public static DaoSet getInstance() {	return instance;	}

	public PreparedStatement getPreStmt(String sql, Object... objects) throws Exception {
		Connection con = DBCon.getConnection(ConFig.URL + ConFig.DB_NAME, ConFig.USER, ConFig.PWD);
		PreparedStatement pStmt = con.prepareStatement(sql);
		for (int i = 0; i < objects.length; i++) {
			pStmt.setObject(i + 1, objects[i]);
		}
		return pStmt;
	}

	public int getQueryCnt(String sql, Object... objects) throws Exception {
		try (PreparedStatement pstmt = getPreStmt(sql, objects)) {
			pstmt.execute();
			int res = pstmt.getUpdateCount();
			return res;
		}
	}

	public ResultSet getQueryRes(String sql, Object... objects) throws Exception {
		PreparedStatement pstmt = getPreStmt(sql, objects);
		return pstmt.executeQuery(); //execute 실행하다
	}

	public int getUpdateResult(String sql, Object... objects) throws Exception {
		return getPreStmt(sql, objects).executeUpdate();
	}
}
