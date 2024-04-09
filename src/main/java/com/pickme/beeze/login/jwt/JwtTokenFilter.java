package com.pickme.beeze.login.jwt;

import java.io.IOException;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Lazy
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

	private JwtTokenProvider provider;
	
	public JwtTokenFilter(JwtTokenProvider provider) {
		System.out.println("JwtTokenFilter(생성자) " + new Date());
		this.provider = provider;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {
		System.out.println("doFilterInternal(JwtTokenProvider) " + new Date());		
		System.out.println("JwtTokenProvider.getAuthentication : " + JwtTokenProvider.httpHeaderKey);
		
		String token = request.getHeader(JwtTokenProvider.httpHeaderKey);	
		
        // 앞에 필요 없는 문자열을 제거
		if(token != null) {
			System.out.println("token:" + BearerRemove(token));
			token = BearerRemove(token);
		}
		
		// System.out.println("token : " + token);
		
        //유효한 토큰인지 확인합니다.
        if (token != null && provider.validateToken(token)) {
        	System.out.println("유효한 토큰 " + new Date());
        	
            // 토큰이 유효하면 토큰으로부터 유저 정보를 받아옵니다.
            Authentication authentication = provider.getAuthentication(token);
            
            //SecurityContext 에 Authentication 객체를 저장합니다. [보안 컨텍스트 업데이트]
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println(authentication);
        }else {
        	System.out.println("유효하지 않은 토큰 " + new Date());
        }
        
        filterChain.doFilter(request, response);	        
	}

	private String BearerRemove(String token) {
        return token.substring("Bearer ".length());
    }

}
