package com.pickme.beeze.manager.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pickme.beeze.manager.dto.EventDto;
import com.pickme.beeze.manager.service.EventService;

import jakarta.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/api/v1/manager/*")
public class EventController {
	
	@Autowired
	EventService service;
	
	// 이벤트 목록 
    @GetMapping("/eventlist")
    public List<EventDto> eventlist(EventDto dto) {
    	
    	System.out.println("EventController eventlist " + new Date());
    	
    	
    	List<EventDto> eventlist = service.eventlist(dto);
    	return eventlist;
    }
    
    // 이벤트 상세보기
    @PostMapping("/eventdetail")
    public EventDto eventdetail(int id) {
    	
    	System.out.println("EventController eventdetail " + new Date());
    	
    	EventDto dto = service.eventdetail(id);
    	
    	return dto;
    }
    
    // 이벤트 생성
    @PostMapping("/eventcreate")
    public String eventcreate(EventDto dto) {
   	
    	System.out.println("EventController evencreate " + new Date());
    	
    	boolean isS = service.eventcreate(dto);
    	
    	if(isS) {
    		return "YES";
    	}
    	else {
    		return "NO";
    	}
    }
    
    // 이벤트 종료
    @GetMapping("/eventstop")
    public String eventstop(int id) {
    	
    	System.out.println("EventController evenstop " + new Date());
    	
   	boolean isS = service.eventstop(id);
    	
    	if(isS) {
    		return "YES";
    	}
    	else {
    		return "NO";
    	}
    }
    

}
