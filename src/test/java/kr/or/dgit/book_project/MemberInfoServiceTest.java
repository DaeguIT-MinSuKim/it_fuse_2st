package kr.or.dgit.book_project;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.service.MemberInfoService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberInfoServiceTest {
	private static MemberInfoService memberinfoservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		memberinfoservice = MemberInfoService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		memberinfoservice = null;
	}
	
	//회원 프로시저 테스트
	/*@Test
	public void TEScallMemberInfo() {
		Map<String, Object> param = new HashMap();
		param.put("m_code", "C009");
		int res = memberinfoservice.callMemberInfo(param);
		//Assert.assertSame(1, res);
	}*/
	
	/*@Test
	public void testinsertMemberInfo(){
		MemberInfo mi = new MemberInfo("C100", "password", "테스트0", "010-111-1111", 12345, "주소는 이러합니다");
		mi.setmGroup('C');
		int res = memberinfoservice.insertMemberInfo(mi);
		Assert.assertSame(1, res);
	}*/
	
	@Test
	public void btestupdateMemberInfo(){
		MemberInfo mi = new MemberInfo("C100", "pass", "테스트1", "010-111-1234", 54321, "주소주소");
		int res = memberinfoservice.updateMemberInfo(mi);
		Assert.assertSame(1, res);
	}
	
	
	@Test
	public void ctestdelMemberInfo(){
		//MemberInfo mi = new MemberInfo("C100", "pass", "테스트1", "010-111-1234", 54321, "주소주소");
		MemberInfo mi = new MemberInfo("C001");
		int res = memberinfoservice.delMemberInfo(mi);
		Assert.assertSame(1, res);
	}
}
