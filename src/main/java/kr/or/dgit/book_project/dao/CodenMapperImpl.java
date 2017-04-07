package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dto.Coden;

public class CodenMapperImpl implements CodenMapper {
	protected String namespace = "kr.or.dgit.book_project.dao.CodenMapper.";
	private static final Log log = LogFactory.getLog(CodenMapper.class);
	private SqlSession sqlSession;
	
	public CodenMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public int insertCoden(Coden coden) {
		log.debug("insertCoden()");
		return sqlSession.insert(namespace + "insertCoden", coden);
	}
	@Override
	public int updateCoden(Coden coden) {
		log.debug("updateCoden()");
		return sqlSession.insert(namespace + "updateCoden", coden);
	}
	@Override
	public List<Coden> selectCodenAll() {
		log.debug("selectCodenAll()");
		return sqlSession.selectList(namespace + "selectCodenAll");
	}
	@Override
	public Coden selectOne(Map<String, Object> param) {
		log.debug("selectOne()");
		return sqlSession.selectOne(namespace + "selectOne",param);
	}
}
