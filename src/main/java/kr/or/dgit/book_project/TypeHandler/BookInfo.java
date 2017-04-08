package kr.or.dgit.book_project.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class BookInfo extends BaseTypeHandler<BookInfo>{

	public BookInfo(String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, BookInfo parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.toString());
		
	}

	@Override
	public BookInfo getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return new BookInfo(rs.getString(columnName));
	}

	@Override
	public BookInfo getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookInfo getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
