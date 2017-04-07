package kr.or.dgit.book_project;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.service.MemberInfoService;

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
	@Test
	public void TESupdateMemberInfo() {
		Map<String, Object> param = new HashMap();
		param.put("m_code", "C009");
		int res = memberinfoservice.updateMemberInfo(param);
		//Assert.assertSame(1, res);
	}
}
