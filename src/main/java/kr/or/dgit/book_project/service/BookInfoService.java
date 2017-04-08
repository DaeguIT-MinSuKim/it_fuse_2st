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
			if (bookInfo.isLending()) {
				JOptionPane.showMessageDialog(null, "대여중인 도서는 폐기가 불가능합니다.");
				return 0;
			}
			bookInfo.setDel(isDel); // 복원이면 false 
			bookInfo.setLending(!isDel); // 대여여부 false
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
}
