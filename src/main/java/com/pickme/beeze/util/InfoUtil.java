package com.pickme.beeze.util;

import java.util.Date;

import org.springframework.security.core.Authentication;


import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;

public class InfoUtil {
	
	public InfoUtil() {
	}

	// 토큰에서 id[seq] 추출
    public static int getUserIdInfo(Authentication Authentication, HttpServletRequest request) {
    	System.out.println("getUserIdInfo(InfoUtil) - 사용자 id(seq) 확인 " + new Date());
    	
    	// 내용 집어넣기
    	String myCode = "bXl0ZWFtMTJpczViZWV6MWFuZDJwaWNrMTIzbWU5NWlzZ29vZHNlcnZpY2U=";
		String token = request.getHeader("Authorization");	
		token = token.substring("Bearer ".length());
        
    	// 회원자의 id 추출
    	int userId = Jwts.parser()
	        		     .setSigningKey(myCode)
	        		     .parseClaimsJws(token)
	        		     .getBody()
	        		     .get("id", Integer.class);
        
        // System.out.println("userId = " + userId);
        return userId;
    }

	// 토큰에서 email[id] 추출
    public static String getUserEmailInfo(Authentication Authentication, HttpServletRequest request) {
    	System.out.println("getUserIdInfo(InfoUtil) - 사용자 id(seq) 확인 " + new Date());
    	
    	// 내용 집어넣기
    	String myCode = "bXl0ZWFtMTJpczViZWV6MWFuZDJwaWNrMTIzbWU5NWlzZ29vZHNlcnZpY2U=";
		String token = request.getHeader("Authorization");	
		token = token.substring("Bearer ".length());
        
    	// 회원자의 id 추출
    	String email = Jwts.parser()
	        		     .setSigningKey(myCode)
	        		     .parseClaimsJws(token)
	        		     .getBody()
	        		     .getSubject();    	
        
        // System.out.println("email = " + email);
        return email;
    }

}
