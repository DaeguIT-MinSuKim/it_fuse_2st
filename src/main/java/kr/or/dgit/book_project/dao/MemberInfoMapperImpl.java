package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dto.MemberInfo;

public class MemberInfoMapperImpl implements MemberInfoMapper {
	private String namespace = "kr.or.dgit.book_project.dao.MemberInfoMapper.";
	private static final Log log = LogFactory.getLog(BookInfoMapper.class);
	private SqlSession sqlSession;

	public MemberInfoMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int selectCountAll() {
		log.debug("selectCountAll()");
		return sqlSession.selectOne(namespace + "selectCountAll");
	}

	@Override
	public int insertMemberInfo(MemberInfo memberInfo) {
		log.debug("insertMemberInfo()");
		return sqlSession.insert(namespace + "insertMemberInfo", memberInfo);
	}

	@Override
	public List<MemberInfo> selectMemberByAll(Map<String, Object> param) {
		log.debug("selectMemberByAll()");
		return sqlSession.selectList(namespace + "selectMemberByAll", param);
	}

	@Override
	public MemberInfo findMemberInfoByCode(MemberInfo memberinfo) {
		log.debug("findMemberInfoByCode()");
		return sqlSession.selectOne(namespace + "findMemberInfoByCode", memberinfo);
	}

	@Override
	public List<MemberInfo> selectMemberByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int callMemberInfo(Map<String, Object> param) {
		log.debug("callPaymentIO()");
		return sqlSession.update(namespace + "callMemberInfo", param);

	}

	@Override
	public int updateMemberInfo(MemberInfo memberInfo) {
		log.debug("updatePaymentIO()");
		return sqlSession.update(namespace + "updateMemberInfo", memberInfo);
	}

	@Override
	public int delMemberInfo(MemberInfo memberInfo) {
		log.debug("delMemberInfo()");
		return sqlSession.update(namespace + "delMemberInfo", memberInfo);

	}
}
