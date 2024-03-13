package com.pickme.beeze.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pickme.beeze.event.dao.EventDao;
import com.pickme.beeze.event.dto.EventDto;


@Service
@Transactional
public class EventService {
	
	@Autowired
	EventDao dao;
	
	// 이벤트 생성 및 삭제
	
	// 이벤트 목록
	public List<EventDto> eventlist(EventDto dto) {
		return dao.eventlist(dto);
	}
	// 이벤트 생성(이미지 url 형식으로 저장)
	public boolean eventcreate(EventDto dto) {
		int count = dao.eventcreate(dto);
		return count>0?true:false;
	}
	// 이벤트 종료
	public boolean eventstop(int id) {
		int count = dao.eventstop(id);
		return count>0?true:false;
	}
	
}
