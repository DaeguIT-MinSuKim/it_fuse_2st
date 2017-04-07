package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.PaymentIO;

public class PaymentIOMapperImpl implements PaymentIOMapper {
	private String namespace="kr.or.dgit.book_project.dao.PaymentIOMapper.";
	private static final Log log = LogFactory.getLog(BookInfoMapper.class);
	private SqlSession sqlSession;	
	public PaymentIOMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<PaymentIO> selectAllPaymentIOInfo(Map<String, Object> param) {
		log.debug("selectAllPaymentIOInfo()");
		return sqlSession.selectList(namespace + "selectAllPaymentIOInfo", param);
	}
	
	@Override
	public int insertPaymentIO(Map<String, Object> param) {
		log.debug("insertPaymentIO()");
		return sqlSession.update(namespace+"insertPaymentIO",param);
	}
	@Override
	public int updatePaymentIO(Map<String, Object> param) {
		log.debug("updatePaymentIO()");		
		return sqlSession.update(namespace+"updatePaymentIO",param);
	}
	
}
