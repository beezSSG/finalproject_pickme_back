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
import com.pickme.beeze.util.S3Service;

import jakarta.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/api/v1/manager/*")
public class EventController {
	
    private final S3Service s3Service;

    @Autowired
    public EventController(S3Service s3Service) {
        this.s3Service = s3Service;
    }

	
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
	public String eventcreate(EventDto dto, 
	                        @RequestParam(value = "uploadfile1", required = false) MultipartFile uploadfile1,
	                        @RequestParam(value = "uploadfile2", required = false) MultipartFile uploadfile2
	                       ) {
	
	    System.out.println("EventController eventcreate " + new Date());
	    
        try {
            // Amazon S3를 통해 파일 업로드
            String s3FileUrl1 = s3Service.uploadFile("mypickmebuket", uploadfile1.getOriginalFilename(), uploadfile1);
            String s3FileUrl2 = s3Service.uploadFile("mypickmebuket", uploadfile1.getOriginalFilename(), uploadfile2);
            
            // 데이터베이스에 Amazon S3 URL 저장
            dto.setBannerPhoto(s3FileUrl1);
            dto.setDetailPhoto(s3FileUrl2);
            boolean isS = service.eventcreate(dto);
            
            if (isS) {
                return "YES";
            } else {
                return "NO";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "NO"; // 업로드 실패 시 NO 반환
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
