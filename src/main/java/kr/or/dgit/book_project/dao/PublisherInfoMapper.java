package kr.or.dgit.book_project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import kr.or.dgit.book_project.dto.PublisherInfo;


public interface PublisherInfoMapper {
	int insertPublisherShort(PublisherInfo publisherInfo);

	int selectCountAll();

	List<PublisherInfo> selectByAll();

	PublisherInfo selectPublisherInfo(PublisherInfo publisherinfo);

	int insertAllPublisherInfo(PublisherInfo publisherInfo);

	int updateSetPublisherInfo(PublisherInfo publisherInfo);

	List<PublisherInfo> selectPublisherInfoByAll(RowBounds rowBounds);

	PublisherInfo selectPublisherInfoOne(Map<String, Object> param);
}
