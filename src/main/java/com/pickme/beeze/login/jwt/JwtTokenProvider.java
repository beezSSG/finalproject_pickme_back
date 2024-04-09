package com.pickme.beeze.login.jwt;

import java.util.Base64;
import java.util.Date;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.pickme.beeze.login.dto.LoginDto;
import com.pickme.beeze.login.security.SecurityService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Lazy
@Component
public class JwtTokenProvider {

    public static String httpHeaderKey = "Authorization";  // 프론트에서 요청보낼때의 key값

    // HTTP헤더에 담을 키값 [HS256(HMAC SHA-256)알고리즘을 사용하는 시크릿 키]
    @Value("${jwt.secret}")
    private String securityKey; // 비밀키
    @Value("${jwt.expiration_time}")
    private long expTime;	// 만료시간

    private final SecurityService userService;	// userService

    public JwtTokenProvider(SecurityService userService){
    	System.out.println("JwtTokenProvider(생성자) " + new Date());
    	this.userService = userService;
    }
    
    // 비밀키 인코딩 객체 초기화, secretKey를 Base64로 인코딩한다.
    @PostConstruct   // 의존성 주입이 이루어진 후 초기화를 수행하는 메서드
    protected void securityKeyEncoding() {
    	System.out.println("securityKeyEncoding(JwtTokenProvider) " + new Date());
    	securityKey = Base64.getEncoder().encodeToString(securityKey.getBytes());
    }
    
    // JWT 토큰 생성
    public String createToken(LoginDto dto) {
    	System.out.println("JWTcreateToken(JwtTokenProvider) - JWT 토큰 생성" + new Date());
    	
        // JWT payload 에 저장되는 정보단위, 보통 여기서 사용자를 식별하는 값을 넣는다.
        Date now = new Date();
        String token = Jwts.builder()
			        	   // signWith : 개인키를 통해 HS512 암호화 알고리즘으로 header와 payload로 Signature를 생성.
			               .signWith(SignatureAlgorithm.HS256, securityKey)  	
			        	   // header 부분
			               .setHeaderParam("typ", "jwt")
			               // payload 부분
			               .setSubject(dto.getEmail())							// 유저email(id)
			               .claim("id", dto.getId())							// 유저id(seq)
			               .setIssuedAt(now) 									// 토큰 발행 시간
			               .setExpiration(new Date(now.getTime() + expTime))	// 만료시간
			//             .setNotBefore(now)
			               .compact();
        
        System.out.println("생성된 token:" + token);
        return token;
    }
    
    // JWT 토큰에서 인증 정보 조회(권한조회)	토큰값을 받아온후 권한을 주는방식으로 변경
    public Authentication getAuthentication(String token) {
    	System.out.println("getAuthentication(JwtTokenProvider) - 권한조회 " + new Date());
    	
        UserDetails userDetails = userService.loadUserByUsername(this.getUserInfo(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
    
    // 토큰의 유효성 + 만료일자 확인(토큰 검사)
    public boolean validateToken(String jwtToken) {
    	System.out.println("validateToken(JwtTokenProvider) - 토큰 검사 " + new Date());
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(securityKey)
                                  .parseClaimsJws(jwtToken);
//            System.out.println(claims);
            return !claims.getBody().getExpiration().before(new Date());
        }
        catch(SignatureException e){	//서명이 옳지 않을 때
    		System.out.println("잘못된 토큰 서명입니다.");
        }
    	catch(ExpiredJwtException e){	//토큰이 만료됐을 때
    		System.out.println("만료된 토큰입니다.");
        }
    	catch(IllegalArgumentException | MalformedJwtException e){	//토큰이 올바르게 구성되지 않았을 때 처리
    		System.out.println("잘못된 토큰입니다.");
        }
		return false;
    }
    
    // 토큰에서 email[id] 추출 (사용자 정보 확인)
    private String getUserInfo(String token) {
    	System.out.println("getUserInfo(JwtTokenProvider) - 사용자 정보 확인 " + new Date());
        
    	// email만 추출하는법
    	String email = Jwts.parser()
		        		   .setSigningKey(securityKey)
		        		   .parseClaimsJws(token)
		        		   .getBody()
		        		   .getSubject();
        
        // System.out.println("email = " + email);
        return email;
    }

}