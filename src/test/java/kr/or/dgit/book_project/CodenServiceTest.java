package kr.or.dgit.book_project;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.service.CodenService;

public class CodenServiceTest {
	private static CodenService codenService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		codenService = new CodenService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		codenService = null;	
	}

	@Test
	public void aTestInsertCoden() {
		Coden cd = new Coden();
		cd.setcName("자연");
		cd.setcCode("N");
		int res = CodenService.insertCoden(cd);
		Assert.assertEquals(1, res);
	}
	@Test
	public void aTestUpdateCoden() {
		Coden cd = new Coden();
		cd.setcName("자연");
		cd.setcCode("T");
		int res = CodenService.updateCoden(cd);
		Assert.assertEquals(1, res);
	}

}
