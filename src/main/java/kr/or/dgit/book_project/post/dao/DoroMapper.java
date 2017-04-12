package kr.or.dgit.book_project.post.dao;

import java.util.List;

import kr.or.dgit.book_project.post.dto.Doro;

public interface DoroMapper {
	List<Doro> selectDoroByDoro(String sido, String doro);
	List<Doro> selectDoroBySido(String sido);
}
