package kr.or.dgit.book_project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dao.MemberInfoMapper;
import kr.or.dgit.book_project.dao.MemberInfoMapperImpl;
import kr.or.dgit.book_project.dao.PaymentIOMapper;
import kr.or.dgit.book_project.dao.PaymentIOMapperImpl;
import kr.or.dgit.book_project.dao.PublisherInfoMapper;
import kr.or.dgit.book_project.dao.PublisherInfoMapperImpl;
import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.util.MybatisSqlSessionFactory;

public class MemberInfoService {

	private static final MemberInfoService instance = new MemberInfoService();

	private MemberInfoService() {
	}

	public static MemberInfoService getInstance() {
		return instance;
	}

	public int selectCountAll(MemberInfo memberInfo) { // 회원 목록 수
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			return memberInfoMapper.selectCountAll(memberInfo);
		}
	}	
	
	public MemberInfo insertMcodeAuto(MemberInfo memberInfo){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			memberInfo.setmGroup('C');
			int memberCnt = selectCountAll(memberInfo);	
			System.out.println(memberCnt);
			
			/*Map<String, Object> map = new HashMap<>();
			map.put("mGroup", "C");*/
			String mCode = String.format("C%03d", memberCnt+1);
			memberInfo.setmCode(mCode);
	/*		int res = memberInfoMapper.insertMcodeAuto(memberInfo);
			sqlSession.commit();*/
			return memberInfo;
		}		
	}

	public int insertMemberInfo(MemberInfo memberInfo) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			int res = memberInfoMapper.insertMemberInfo(memberInfo);
			sqlSession.commit();
			return res;
		}
	}

	public List<MemberInfo> selectMemberByAll(Map<String, Object> param) { // 전체 회원 출력
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			return memberInfoMapper.selectMemberByAll(param);
		}
	}

	// 코드 하나 빼올라고 실험중임
	public MemberInfo findMemberInfoByCode(MemberInfo code) { // 멤버 검색
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			return memberInfoMapper.findMemberInfoByCode(code);
		}
	}

	// 회원 프로시저
	public int callMemberInfo(Map<String, Object> param) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			return memberInfoMapper.callMemberInfo(param);
		}
	}

	public int updateMemberInfo(MemberInfo memberInfo) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			int res = memberInfoMapper.updateMemberInfo(memberInfo);
			sqlSession.commit();
			// JOptionPane.showMessageDialog(null, "회원정보 수정완료");
			return res;
		}
	}

	public int delMemberInfo(MemberInfo memberInfo) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			int res = memberInfoMapper.delMemberInfo(memberInfo);
			sqlSession.commit();
			// JOptionPane.showMessageDialog(null, "회원탈퇴 성공");
			return res;
		}
	}

	public boolean confirmPW(MemberInfo memberinfo) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			MemberInfoMapper memberInfoMapper = new MemberInfoMapperImpl(sqlSession);
			return memberInfoMapper.confirmPW(memberinfo);
		}
	}

}
