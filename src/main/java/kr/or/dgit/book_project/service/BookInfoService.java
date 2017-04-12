package kr.or.dgit.book_project.service;

import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dao.BookInfoMapper;
import kr.or.dgit.book_project.dao.BookInfoMapperImpl;
import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.util.MybatisSqlSessionFactory;

public class BookInfoService {
	private static final BookInfoService instance = new BookInfoService();

	private BookInfoService() {
	}

	public static BookInfoService getInstance() {
		return instance;
	}

	public int insertBookInfo(BookInfo bookInfo) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			int res = bookInfoMapper.insertBookInfo(bookInfo);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "도서등록완료");
			return res;
		}
	}

	public int setDelBookInfo(BookInfo bookInfo, boolean isDel) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			
			bookInfo.setDel(isDel); // 복원이면 false
			int res = bookInfoMapper.setDelBookInfo(bookInfo);
			sqlSession.commit();
			if (bookInfo.isDel()) {
				// 도서 삭제완료
				JOptionPane.showMessageDialog(null, "도서폐기완료");
			} else {
				// 도서 복원완료
				JOptionPane.showMessageDialog(null, "도서복원완료");
			}
			/*
			 * if(!bookInfo.isDel()){ bookInfo.setDel(true); res =
			 * bookInfoMapper.setDelBookInfo(bookInfo); sqlSession.commit(); //
			 * 도서 삭제 완료 JOptionPane.showMessageDialog(null, "도서폐기완료"); }else{
			 * bookInfo.setDel(false); res =
			 * bookInfoMapper.setDelBookInfo(bookInfo); sqlSession.commit(); //
			 * 도서 복원완료 JOptionPane.showMessageDialog(null, "도서복원완료"); }
			 */
			return res;
		}
	}

	public int updateBookInfo(BookInfo bookInfo) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			int res = bookInfoMapper.updateBookInfo(bookInfo);
			sqlSession.commit();
			JOptionPane.showMessageDialog(null, "도서정보 수정완료");
			return res;
		}
	}

	public List<BookInfo> selectBookInfo(Map<String, Object> param) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.selectBookInfo(param);
		}

	}

	/*
	 * public List<BookInfo> selectBookInfoByAllBook(Boolean isDel) { try
	 * (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
	 * BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
	 * return bookInfoMapper.selectBookInfoByAllBook(isDel); } }
	 */

	public int countBookInfo(Map<String, Object> param) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.countBookInfo(param);
		}
	}

	public BookInfo selectBookInfoOne(Map<String, Object> param) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.selectBookInfoOne(param);
		}
	}

	public List<BookInfo> selectAllBookInfo(Map<String, Object> param) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.selectAllBookInfo(param);
		}
	}

	// 대여 테이블
	public List<BookInfo> selectIslending(Map<String, Object> param) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.selectIslending(param);
		}
	}

	public BookInfo selectOnlyBookInfo(BookInfo bookInfo) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.selectOnlyBookInfo(bookInfo);
		}
	}
	/*총 보유 권수*/
	public List<Map<String, Object>> selectAllCountBookInfo(){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.selectAllCountBookInfo();
		}
	}
	/*분야별 보유 권수*/
	public List<BookInfo> subCountBookInfo(int subBookSize){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.subCountBookInfo(subBookSize);
		}
	}
	/*분야별 보유 권수*/
	public List<BookInfo> blackCountBookInfo(int blackCountBookSize){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.blackCountBookInfo(blackCountBookSize);
		}
	}
	/*분야별 보유 권수*/
	public List<BookInfo> lendCountBookInfo(int lendCountBookSize){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			BookInfoMapper bookInfoMapper = new BookInfoMapperImpl(sqlSession);
			return bookInfoMapper.lendCountBookInfo(lendCountBookSize);
		}
	}
}
