package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.book_project.dto.Coden;


public interface CodenMapper {
	
	int insertCoden(Coden coden);
	int updateCoden(Coden coden);
	
	List<Coden> selectCodenAll();
	Coden selectOne (Map<String, Object> param);
}
