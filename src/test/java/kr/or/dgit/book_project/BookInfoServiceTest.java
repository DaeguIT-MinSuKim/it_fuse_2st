package kr.or.dgit.book_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.book_project.dao.BookInfoMapper;
import kr.or.dgit.book_project.dao.BookInfoMapperImpl;
import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.util.MybatisSqlSessionFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookInfoServiceTest {
	private static BookInfoService bookInfoService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookInfoService = BookInfoService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bookInfoService = null;
	}

	/*@Test
	public void atestselectBookInfoCountBy() { ///됨
		Map<String, Object> param = new HashMap<>();
		param.put("bSubCode", 0);
		param.put("cName", "IT");
		int res = bookInfoService.countBookInfo(param);
		System.out.println("검색 조건 : " + param);
		System.out.println(res);
		Assert.assertNotNull(res);
	}*/

	/*@Test public void btestinsertBookInfo() {
		insert into bookInfo(b_code, b_sub_code, c_name, b_name,
				author, p_code, price, insert_date) values
				(#{bCode},#{bSubCode},#{coden.cName},
						#{bName},#{author},#{publisherInfo.pCode},#{price}, current_date); 
		
	PublisherInfo pCode = new PublisherInfo(); 
	 pCode.setpCode("P022"); // 외래키관계는 있는 데이터 선택해야함 
	 pCode.setPublisher("다산지식하우스");
	 
	 
	 
	 Coden cName = new Coden("자기계발", "D"); // 있는 데이터 선택해야함 
	 BookInfo bookInfo = 
			 new BookInfo("D005", "0", cName, "입력테스트", "저자임", pCode, 12000); 	 
	 
	 int res = bookInfoService.insertBookInfo(bookInfo); Assert.assertSame(1, res); 
	 }*/
	 
/*
	@Test
	public void ctestupdateBookInfo() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setbCode("D005");
		bookInfo.setbSubCode("0");
		bookInfo.setbName("수정중");
		bookInfo.setAuthor("저자수정");
		bookInfo.setPrice(10);

		int res = bookInfoService.updateBookInfo(bookInfo);
		Assert.assertSame(1, res);
	}
	
	@Test
	public void ctestupdateDelBookInfo() {

		BookInfo bookInfo = new BookInfo();
		bookInfo.setbCode("D005");
		bookInfo.setbSubCode("00");

		int res = bookInfoService.delBookInfo(bookInfo);
		Assert.assertSame(1, res);
	}

	@Test
	public void dtestselectBookInfo() { // 굳굳
		BookInfo bookInfo = new BookInfo();
		bookInfo.setbCode("T001");
		bookInfo.setbSubCode("0");

		Map<String, Object> param = new HashMap<>();
		param.put("isDel", false);
		param.put("bCode", "T001");
		param.put("bSubCode", "00");
		List<BookInfo> bookInfoRes = bookInfoService.selectBookInfo(param);
		Assert.assertNotNull(bookInfoRes);

	}

	@Test
	public void etestselectBookInfoByAllBook() {
		System.out.println("폐기도서 목록");
		List<BookInfo> list = bookInfoService.selectBookInfoByAllBook(true); // 폐기도서
		Assert.assertNotNull(list);

		System.out.println("정상도서 목록");
		list = bookInfoService.selectBookInfoByAllBook(false); // 정상도서
		Assert.assertNotNull(list);

	}
	
	
	@Test
	public void ftestselectBookInfoOne() {
		BookInfo bi = new BookInfo();
		bi.setbCode("D005");
		bi.setbSubCode("0");
		
		BookInfo binew = bookInfoService.selectBookInfoOne(bi);
		Assert.assertNotNull(bi);

	}*/
	
	/*@Test
	public void TESTselectAllBookInfo() {
		
		Map<String, Object> param = new HashMap<>();
		param.put("isDel", true);
		List<BookInfo> binew = bookInfoService.selectAllBookInfo(param);
		Assert.assertNotNull(binew);

	}*/
	
	@Test
	public void TESTselectBookInfoOne() {
		/*BookInfo bi = new BookInfo();
		bi.setbCode("T001");
		bi.setbSubCode("2");
		
		BookInfo binew = bookInfoService.selectBookInfoOne(bi);
		Assert.assertNotNull(bi);*/
		
		
		/*Map<String, Object> param = new HashMap<>();
		param.put("bCode", "T001");
		param.put("bSubCode", "2");
		List<BookInfo> bi = bookInfoService.selectBookInfoOne(param);
		Assert.assertNotNull(bi);*/
	}

}
