package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.book_project.dto.BookInfo;


public interface BookInfoMapper {
	int insertBookInfo(BookInfo bookInfo); // 도서 추가

	int updateBookInfo(BookInfo bookInfo); // 도서 정보 수정

	int delBookInfo(BookInfo bookInfo); // 도서 폐기/복원
	
	BookInfo selectBookInfoOne(BookInfo bookInfo);

	/////////////////////////////////////////////////////////

	List<BookInfo> selectBookInfoByAllBook(Boolean isDel); // 폐기/ 정상 도서 리스트 출력하기

	///////////////////////////////////////////////////////////////
	// 분야/특정 코드의 책 갯수 가져오기
	int selectBookInfoCountBy(Map<String, Object> param);

	List<BookInfo> selectBookInfo(Map<String, Object> param); // 
	

	//////////////////////////////
	
	List<BookInfo> selectAllBookInfo(Map<String, Object> param);

	// 대여 테이블 
	List<BookInfo> selectIslending();
}
