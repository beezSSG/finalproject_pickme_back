package com.pickme.beeze.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.manager.dto.EventDto;

@Mapper
@Repository
public interface EventDao {

	// 이벤트 생성 및 삭제
	
	// 이벤트 목록
	List<EventDto> eventlist(EventDto dto);
	// 이벤트 상세보기
	EventDto eventdetail(int id);
	// 이벤트 생성(이미지 url 형식으로 저장)
	int eventcreate(EventDto dto);
	// 이벤트 종료
	int eventstop(int id);
	
}
