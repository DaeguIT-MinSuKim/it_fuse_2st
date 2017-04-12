package kr.or.dgit.book_project.dao;

import java.util.List;

import kr.or.dgit.book_project.dto.Doro;

public interface DoroMapper {
	List<Doro> selectDoroByDoro(String sido, String doro);
	List<Doro> selectDoroBySido(String sido);
}
