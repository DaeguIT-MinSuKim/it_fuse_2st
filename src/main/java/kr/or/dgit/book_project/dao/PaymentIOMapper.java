package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.PaymentIO;

public interface PaymentIOMapper {
	
	List<PaymentIO> selectAllPaymentIOInfo(Map<String, Object> param);
	
	//대여 프로시저
	int insertPaymentIO(Map<String, Object> param);
	//반납 프로시저
	int updatePaymentIO(Map<String, Object> param);
	
}
