package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.book_project.dto.BookInfo;


public interface BookInfoMapper {
	int insertBookInfo(BookInfo bookInfo); // 도서 추가

	int updateBookInfo(BookInfo bookInfo); // 도서 정보 수정
	int setDelBookInfo(BookInfo bookInfo); // 도서 폐기/복원
	
	BookInfo selectBookInfoOne(Map<String, Object> param);

	int countBookInfo(Map<String, Object> param);

	List<BookInfo> selectBookInfo(Map<String, Object> param); // 
	

	//////////////////////////////
	
	List<BookInfo> selectAllBookInfo(Map<String, Object> param);

	// 대여 테이블 
	List<BookInfo> selectIslending(Map<String, Object> param);

}
