package com.pickme.beeze.login.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.login.dao.LoginDao;
import com.pickme.beeze.login.dto.LoginDto;
import com.pickme.beeze.login.dto.OcrListDto;
import com.pickme.beeze.util.MailService;

@Service
@Transactional
public class LoginService {
    
	private final LoginDao dao;

    public LoginService(LoginDao dao) {
        this.dao = dao;
    }
	
	// 메일 서비스 연결
	@Autowired
	private MailService mailService;

	/* 회원가입 */
	public int addCustomerInfo(LoginDto dto) {
		return dao.addCustomerInfo(dto);
	}
	public int addCeoInfo(LoginDto dto) {
		return dao.addCeoInfo(dto);
	}
	
	/* 이메일(id) 중복확인 */
	public int countCustomerInfo(String email) {
		return dao.countCustomerInfo(email);
	}
	public int countCeoInfo(String email) {
		return dao.countCeoInfo(email);
	}
	
	/* 로그인전 정보확인 */
	public LoginDto whoCustomer(String email) {
		return dao.whoCustomer(email);
	}
	public LoginDto whoCeo(String email) {
		return dao.whoCeo(email);
	}
	
	/* 로그인 */
	public LoginDto selectCustomerInfo(LoginDto dto) {
		return dao.selectCustomerInfo(dto);
	}
	public LoginDto selectCeoInfo(LoginDto dto) {
		return dao.selectCeoInfo(dto);
	}
	
	/* 아이디/비밀번호 찾기 */
	public String findEmail(LoginDto dto) {
		String email = dao.findCustomerEmail(dto);
		if (email == null || email.equals("")) {
			email = dao.findCeoEmail(dto);
		}
		return email;
	}
	
	/* 이메일 인증서비스 */
    public String sendCodeToEmail(String toEmail) {
        
        String title = "[Pick ME] 인증코드 요청";	// 이메일 제목
        String authCode = this.createTempPw();	// 이메일 내용 = 임시비번
                                                                                                                                                                                                                                                                                                                                                                                                       
        // 아래와 같이 메일을 보낼 수 있고 img를 보내고 싶으면 <img>를 사용하여 
	    String content =
	    		"<html><body>" +
	            "<p>안녕하세요, Pick Me를 이용하시는 회원님!</p>" +
	            "<p>요청하신 인증코드를 보내드립니다. </p>"+
	            "<p>만약 인증코드를 요청하지 않았다면 이 이메일을 무시해주시기 바랍니다.</p><br/><br/>" +
	            "<p>     인증코드 : <b>" + authCode + "</b></p><br/><br/>" +
	            "<p>관련하여 도움이 필요하시거나 다른 문의사항이 있다면 언제든지 Pick ME로 연락해주세요</p><br/><br/>" +
	            "<p> Pick ME 드림</p>" ;

      	// 이메일 인증 요청 시 인증 번호        
        mailService.sendEmail(toEmail, title, content);
        
        return authCode;
    }
	
    //임시비밀번호 생성구간
  	public String createTempPw() {

        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();
      	  
        // 임시 비밀번호 조합용
        final String SPECIAL_CHARACTERS = "!@#$%^&*()_-+=<>?";
        final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
        final String DIGITS = "0123456789";
        String allCharacters = SPECIAL_CHARACTERS + UPPERCASE_LETTERS + LOWERCASE_LETTERS + DIGITS;

        // 임시 비밀번호 6개
        for (int i = 0; i < 6; i++) {
            password.append(getRandomChar(allCharacters, random));
        }

        return shuffleString(password.toString(), random);
  	}
  	
  	// 임시 비밀번호 뽑기
	private char getRandomChar(String characterSet, SecureRandom random) {
		int randomIndex = random.nextInt(characterSet.length());
	    return characterSet.charAt(randomIndex);
	}
  
	// 임시 비밀번호 섞기
	private String shuffleString(String input, SecureRandom random) {
	    char[] characters = input.toCharArray();
	    for (int i = characters.length - 1; i > 0; i--) {
	        int randomIndex = random.nextInt(i + 1);
	        char temp = characters[i];
	        characters[i] = characters[randomIndex];
	        characters[randomIndex] = temp;
	    }
	    return new String(characters);
	}
	
	// 임시 비밀번호 확인 후 비밀번호 변경
	public int changePw(LoginDto dto) {
		LoginDto member = dao.whoCustomer(dto.getEmail());
		int isS = 0;
		if (member.getRdate() == null || member.getRdate().equals("")) {
			member = dao.whoCeo(dto.getEmail());
			isS = dao.changeCeoPw(member);
			return isS;
		}
		isS = dao.changeCustomerPw(dto);
		return isS;
	}
	
	/* 토큰값을 통한 회원확인 */
	public LoginDto searchCustomerInfo(int id) {
		return dao.searchCustomerInfo(id);
	}
	public LoginDto searchCeoInfo(int id) {
		return dao.searchCeoInfo(id);
	}
	
	/* ocr url 넣기(관리자에 필요함)*/
	public void ocrurl(String fullUrl) {
		dao.ocrurl(fullUrl);
	}
	public List<OcrListDto> selectocrlist(OcrListDto dto) {
		return dao.selectocrlist(dto);
	}
	public OcrListDto ocrlistdetail(int id) {
		return dao.ocrlistdetail(id);
	}
	public boolean ocrapproval(int id) {
		return dao.ocrapproval(id)>0?true:false;
	}
	public int notocrcount(OcrListDto dto) {
		return dao.notocrcount(dto);
	}
	
	/* 회원탈퇴 */
	public void deleteCustomer(int id) {
		dao.deleteCustomer(id);
	}
}
