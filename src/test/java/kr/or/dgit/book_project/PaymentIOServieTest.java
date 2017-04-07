package kr.or.dgit.book_project;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.book_project.service.PaymentIOService;

public class PaymentIOServieTest {
	private static PaymentIOService paymentIOServie;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		paymentIOServie = PaymentIOService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		paymentIOServie = null;
	}

	/*
	 * @Test public void TESTselectAllPaymentIOInfo() {
	 * 
	 * Map<String, Object> param = new HashMap<>(); param.put("mCode", "C005");
	 * 
	 * List<PaymentIO> newList = paymentIOServie.selectAllPaymentIOInfo(param);
	 * Assert.assertNotNull(newList);
	 * 
	 * }
	 */
	/*
	 * @Test public void TESgetbcode() {
	 * 
	 * List<PaymentIO> newList = paymentIOServie.selectAllPaymentIOInfo(param);
	 * Assert.assertNotNull(newList);
	 * 
	 * }
	 */

	/*@Test
	public void TESprocedureTest() {
		Map<String, Object> param = new HashMap();
		param.put("b_code", "J001");
		param.put("b_sub_code", 00);
		param.put("m_code", "C004");
		int res = paymentIOServie.insertPaymentIO(param);
		//Assert.assertSame(1, res);
	}*/
	
	@Test
	public void TESupdatePaymentIO() {
		Map<String, Object> param = new HashMap();
		param.put("b_code", "H002");
		param.put("b_sub_code", 0);
		param.put("m_code", "C009");
		param.put("return_date", "2017-04-07");
		int res = paymentIOServie.updatePaymentIO(param);
		//Assert.assertSame(1, res);
		// 헐 됨.. 성공 함... black date 나옴... 한달뒤인 5월 7일... 
		
		
	}
}
