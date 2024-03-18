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
	public String eventcreate(EventDto dto, 
	                        @RequestParam(value = "uploadfile1", required = false) MultipartFile uploadfile1,
	                        @RequestParam(value = "uploadfile2", required = false) MultipartFile uploadfile2,
	                        HttpServletRequest request) {
	
	    System.out.println("ProductController newproductinsert " + new Date());
	    
	    // 파일 업로드 경로를 static 폴더로 변경
	    String staticPath = "src/main/resources/static/upload";
	    
	    // 파일명을 변경하여 파일을 static 폴더에 저장
	    String filename1 = uploadfile1.getOriginalFilename();
	    String newfilename1 = getNewFileName(filename1);
	    String filepath1 = staticPath + "/" + newfilename1;
	    System.out.println(filepath1);
	    
	    String filename2 = uploadfile2.getOriginalFilename();
	    String newfilename2 = getNewFileName(filename2);
	    String filepath2 = staticPath + "/" + newfilename2;
	    System.out.println(filepath2);
	    
	    // 파일 저장
	    try {
	        BufferedOutputStream os1 = new BufferedOutputStream(new FileOutputStream(filepath1));
	        os1.write(uploadfile1.getBytes()); // 파일 업로드
	        os1.close();
	        
	        BufferedOutputStream os2 = new BufferedOutputStream(new FileOutputStream(filepath2));
	        os2.write(uploadfile2.getBytes()); // 파일 업로드
	        os2.close();
	    } catch (FileNotFoundException e) {            
	        e.printStackTrace();
	    } catch (IOException e) {            
	        e.printStackTrace();
	    }
	    
	    // 데이터베이스에 전체 URL 저장
	    String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
	    String fullUrl1 = baseUrl + "/upload/" + newfilename1; // 전체 URL 생성
	    dto.setBannerPhoto(fullUrl1);
	    
	    String fullUrl2 = baseUrl + "/upload/" + newfilename2; // 전체 URL 생성
	    dto.setDetailPhoto(fullUrl2);
	    
	    boolean isS = service.eventcreate(dto);
	    
	    if (isS) {
	        return "YES";
	    } else {
	        return "NO";
	    }
	}

	private static String getNewFileName(String filename) {
		String newfilename = "";
		String fpost = "";	// .jpg .txt 등 확장자명을 끄집어냄
		
		if(filename.indexOf('.') >= 0) {	// 확장자명이 있음
			fpost = filename.substring(filename.indexOf('.'));	// .txt
			newfilename = new Date().getTime() + fpost;	// 43534534.txt
		}else {
			newfilename = new Date().getTime() + ".back";
		}
		
		return newfilename;
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
