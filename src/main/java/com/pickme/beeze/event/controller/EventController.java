package com.pickme.beeze.event.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pickme.beeze.event.dto.EventDto;
import com.pickme.beeze.event.service.EventService;
import jakarta.servlet.http.HttpServletRequest;



@RestController
public class EventController {
	
	@Autowired
	EventService service;
	
	// 이벤트 목록 
    @GetMapping("eventlist")
    public List<EventDto> eventlist(EventDto dto) {
    	
    	System.out.println("EventController eventlist " + new Date());
    	
    	
    	List<EventDto> eventlist = service.eventlist(dto);
    	return eventlist;
    }
    
    // 이벤트 생성
//    @GetMapping("eventcreate")
//    public String eventcreate(int id) {
//    	
//    	System.out.println("EventController evencreate " + new Date());
//    }
//    

}
