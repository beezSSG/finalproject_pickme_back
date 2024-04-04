package com.pickme.beeze.login.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pickme.beeze.login.dto.LoginDto;
import com.pickme.beeze.login.jwt.JwtTokenProvider;
import com.pickme.beeze.login.service.LoginService;
import com.pickme.beeze.util.InfoUtil;
import com.pickme.beeze.util.NaverCloud;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1/user/*")
public class LoginController {

	@Autowired
	private LoginService service;

    // JWT 토큰 생성을 위해 필요
    @Autowired
    private JwtTokenProvider provider;
    
    // 테스트[방식을 이렇게 해야함]
    @GetMapping("/test")
    public String test(Authentication Authentication, HttpServletRequest request) {
    	System.out.println("LoginController test " + new Date());
    	
    	int id = InfoUtil.getUserIdInfo(Authentication, request);
    	System.out.println("id = " + id);
    	
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
	
    // 이메일 체크
    @GetMapping("/countEmail")
    public int countEmail(String email) {
    	System.out.println("LoginController countEmail " + new Date());
    	
    	int count = service.countCustomerInfo(email);
    	
    	if (count == 0) {
			count = service.countCeoInfo(email);
		}
    	
    	return count;
    }
	
	// 점주 회원가입시 OCR
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
    
    // 토큰 적용 로그인
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto dto){
    	System.out.println("LoginController login " + new Date());
            
        // email, pw 통한 사용자 구분
        System.out.println(dto.toString());
    	LoginDto member2 = service.selectCustomerInfo(dto);
		if (member2 == null || member2.getRdate() == null || member2.getRdate().equals("")) {	// 고객 로그인
			member2 = service.selectCeoInfo(dto);
		} else {	// 점주 로그인
			member2 = service.selectCustomerInfo(dto);
		}			// 관리자 로그인

        // JWT 토큰 생성 및 반환
        String jwt = provider.createToken(member2);
        
        // 생성된 JWT 토큰을 응답 본문에 담아 반환            
        return ResponseEntity.ok(jwt);
    }
    
    // 아이디 찾기
    @GetMapping("/findEmail")
    public String findEmail(LoginDto dto) {
    	System.out.println("LoginController findEmail " + new Date());
    	
    	return service.findEmail(dto);
    }
    
    // 이메일 발송 ( 이메일 인증 / 비밀번호 찾기 겸용 )
    @PostMapping("/sendCodeToEmail")
    public ResponseEntity<?> sendCodeToEmail(String email) {
    	System.out.println("LoginController sendCodeToEmail " + new Date());
        String tempCode = service.sendCodeToEmail(email);

        return ResponseEntity.ok(tempCode);
    }

    // 생성자를 통해 토큰을 초기화
    // 이메일 확인후 비밀번호 변경시
    @PostMapping("/changePw")
    public ResponseEntity<?> changePw(LoginDto dto) {
    	System.out.println("LoginController changePw " + new Date());
    	
        return ResponseEntity.ok(service.changePw(dto));
    }
    
}
