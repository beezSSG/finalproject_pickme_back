package com.pickme.beeze.login.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.naming.AuthenticationException;
import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pickme.beeze.login.dto.LoginDto;
import com.pickme.beeze.login.dto.TokenDto;
import com.pickme.beeze.login.dto.UserDto;
import com.pickme.beeze.login.jwt.JwtTokenProvider;
import com.pickme.beeze.login.security.SecurityService;
import com.pickme.beeze.login.service.LoginService;
import com.pickme.beeze.util.NaverCloud;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("api/v1/user/*")
public class LoginController {

	@Autowired
	private LoginService service;
	
	
    // AuthenticationManager를 스프링에서 자동으로 주입받아 사용
    // 사용자 인증을 위해 필요합니다.
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    SecurityService loginService;

    // JWT 토큰 생성을 위해 필요
    @Autowired
    private JwtTokenProvider provider;
    
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto dto){
    	System.out.println("LoginController login " + new Date());
    	
    	try {
            // 사용자 인증
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            dto.getEmail(),
//                            dto.getPw()
//                    )
//            );
            System.out.println("1/3 지점 도달");
            
            // member_id, password 체크
            System.out.println(dto.toString());
        	LoginDto member2 = service.selectCustomerInfo(dto);
    		if (member2.getRdate() != null || !member2.getRdate().equals("")) {	// 고객 로그인
    			member2 = service.selectCustomerInfo(dto);
    		} else {	// 점주 로그인
    			member2 = service.selectCeoInfo(dto);
    		}
    		System.out.println("2/3 지점 도달");

            // JWT 토큰 생성 및 반환
            String jwt = provider.createToken(member2);
            System.out.println("3/3 지점 도달");
            // 생성된 JWT 토큰을 응답 본문에 담아 반환
            
            // Authorization 헤더에 토큰 추가
//            request.addHeader("Authorization", "Bearer " + token);
            
            return ResponseEntity.ok(new JwtResponse(jwt));
        }
        catch(Exception e){
            // 그 외 에러의 경우 500 메세지
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 내부 오류");
        }
    }
    
    // JWT 토큰을 담을 내부 클래스를 정의
    @Getter
    @Setter
    class JwtResponse {
        private String token;

        // 생성자를 통해 토큰을 초기화
        public JwtResponse(String token) {
            this.token = token;
        }
    }
	
    // 테스트
    @GetMapping("/test")
    public String test() {
    	System.out.println("LoginController test " + new Date());
    	
    	return "성공";
    }
    
	/* TODO 통합 로그인 기능 */
	// 고객 회원가입
	@PostMapping("/regiCustomer")
	public int addCustomer(LoginDto dto) {
		System.out.println("LoginController regiCustomer " + new Date());
		
		System.out.println(dto.toString());
		
		return service.addCustomerInfo(dto); // 0: 회원가입실패 / 1: 회원가입성공
	}
	// 점주 회원가입
	@PostMapping("/regiCeo")
	public int regiCeo(LoginDto dto) {
		System.out.println("LoginController regiCeo " + new Date());
		
		return service.addCeoInfo(dto);	// 0: 회원가입실패 / 1: 회원가입성공
	}
	
	// 고객 및 점주 로그인
	/*
	@PostMapping("/login")
	public LoginDto login(LoginDto dto) {
		System.out.println("LoginController login " + new Date());
		
		LoginDto user;
		// 확인작업
		user = service.whoCustomer(dto);
		
		if (user.getRdate() != null || !user.getRdate().equals("")) {	// 고객 로그인
			user = service.selectCustomerInfo(dto);
		} else {	// 점주 로그인
			user = service.selectCeoInfo(dto);
		}
		
		System.out.println(user.toString());
		return user;
	}
	*/
	// 관리자 로그인

	
	// OCR
	@PostMapping("/ocr")
	public String ocr(@RequestParam("uploadfile")MultipartFile uploadfile,
							HttpServletRequest re) throws Exception {
		System.out.println("NaverCloudController ocr " + new Date());
		
		String uploadPath = re.getServletContext().getRealPath("/upload");
		
		// 파일명을 취득
		String filename = uploadfile.getOriginalFilename();
		String filepath = uploadPath + File.separator + filename;	// uploadPath + / + filename
		
		System.out.println(filepath);
		
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		os.write(uploadfile.getBytes());
		os.close();
		
		// Naver cloud
		NaverCloud nc = new NaverCloud();
		String response = nc.OcrProc(filepath);
		return response;
	}
	
	
	/* TODO 토근 적용 로그인 */
}
