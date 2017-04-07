package kr.or.dgit.book_project.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dao.BookInfoMapper;
import kr.or.dgit.book_project.dao.BookInfoMapperImpl;
import kr.or.dgit.book_project.dao.PaymentIOMapper;
import kr.or.dgit.book_project.dao.PaymentIOMapperImpl;
import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.PaymentIO;
import kr.or.dgit.book_project.util.MybatisSqlSessionFactory;

public class PaymentIOService {
	
	private static final PaymentIOService instance = new PaymentIOService();
	
	private PaymentIOService() {
		
	}
	
	public static PaymentIOService getInstance() {
		return instance;
	}

	public List<PaymentIO> selectAllPaymentIOInfo(Map<String, Object> param) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			PaymentIOMapper paymentIOMapper = new PaymentIOMapperImpl(sqlSession);
			return paymentIOMapper.selectAllPaymentIOInfo(param);
		}
	}
	
	public int insertPaymentIO(Map<String, Object> param){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			PaymentIOMapper paymentIOMapper = new PaymentIOMapperImpl(sqlSession);
			return paymentIOMapper.insertPaymentIO(param);
		}
	}
	
	public int updatePaymentIO(Map<String, Object> param){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			PaymentIOMapper paymentIOMapper = new PaymentIOMapperImpl(sqlSession);
			return paymentIOMapper.updatePaymentIO(param);
		}
	}
	
}
