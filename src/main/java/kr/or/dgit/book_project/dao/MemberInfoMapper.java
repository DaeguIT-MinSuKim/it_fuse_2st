package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.book_project.dto.MemberInfo;

public interface MemberInfoMapper {
	int selectCountAll();								//회원 수 
	int insertMemberInfo(MemberInfo memberInfo);		//회원삽입

	List<MemberInfo> selectMemberByAll(Map<String, Object> param);	//목록출력
	
	// 한개만 가져오는 거
	// 출력 (조건 셋팅 시 조건에 해당되는 데이터만 끌어오기)

	List<MemberInfo> selectMemberByAll();				//목록출력
	MemberInfo findMemberInfoByCode(MemberInfo memberinfo);	//회원검색
	
}
