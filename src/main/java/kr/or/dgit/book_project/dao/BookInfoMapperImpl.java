package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dto.BookInfo;

public class BookInfoMapperImpl implements BookInfoMapper {
	private String namespace = "kr.or.dgit.book_project.dao.BookInfoMapper.";
	private static final Log log = LogFactory.getLog(BookInfoMapper.class);
	private SqlSession sqlSession;

	public BookInfoMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertBookInfo(BookInfo bookInfo) {
		log.debug("insertBookInfo()");
		return sqlSession.insert(namespace + "insertBookInfo", bookInfo);
	}

	@Override
	public int updateBookInfo(BookInfo bookInfo) {
		log.debug("updateBookInfo()");
		return sqlSession.update(namespace + "updateBookInfo", bookInfo);
	}

	@Override
	public List<BookInfo> selectBookInfo(Map<String, Object> param) {
		log.debug("selectBookInfo()");
		return sqlSession.selectList(namespace + "selectBookInfo", param);
	}

	@Override
	public int countBookInfo(Map<String, Object> param) {
		log.debug("countBookInfo()");
		return sqlSession.selectOne(namespace + "countBookInfo", param);
	}

	@Override
	public int setDelBookInfo(BookInfo bookInfo) {
		log.debug("setDelBookInfo()");
		return sqlSession.update(namespace + "setDelBookInfo", bookInfo);
	}

	@Override
	public BookInfo selectBookInfoOne(Map<String, Object> param) {
		log.debug("selectBookInfoOne()");
		return sqlSession.selectOne(namespace + "selectBookInfoOne", param);
	}

	// 대여 테이블
	@Override
	public List<BookInfo> selectIslending(Map<String, Object> param) {
		log.debug("selectIslending");
		return sqlSession.selectList(namespace+"selectIslending",param);

	}

	@Override
	public List<BookInfo> selectAllBookInfo(Map<String, Object> param) {
		log.debug("selectAllBookInfo()");
		return sqlSession.selectList(namespace + "selectAllBookInfo", param);
	}

}