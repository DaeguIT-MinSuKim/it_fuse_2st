package kr.or.dgit.book_project.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dao.MemberInfoMapper;
import kr.or.dgit.book_project.dao.MemberInfoMapperImpl;
import kr.or.dgit.book_project.dao.PaymentIOMapper;
import kr.or.dgit.book_project.dao.PaymentIOMapperImpl;
import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.util.MybatisSqlSessionFactory;

public class MemberInfoService {
	
	private static final MemberInfoService instance = new MemberInfoService();
	private MemberInfoService() {	}
	public static MemberInfoService getInstance() {
		return instance;
	}


	public int selectCountAll(){		// 회원 목록 수
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			int res = memberInfoMapper.selectCountAll();
			return res;
		}
	}
	
	public int insertMemberInfo(MemberInfo memberInfo){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			int res = memberInfoMapper.insertMemberInfo(memberInfo);
			sqlSession.commit();
			return res;
		}				
	}
	
	public List<MemberInfo> selectMemberByAll(Map<String, Object> param){		// 전체 회원 출력
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			return memberInfoMapper.selectMemberByAll(param);
		}				
	}
	// 코드 하나 빼올라고 실험중임
	public MemberInfo findMemberInfoByCode(MemberInfo code){		// 멤버 검색
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			return memberInfoMapper.findMemberInfoByCode(code);
		}
	}	
	// 회원 프로시저
	public int updateMemberInfo(Map<String, Object> param){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			return memberInfoMapper.updateMemberInfo(param);
		}
	}
}



