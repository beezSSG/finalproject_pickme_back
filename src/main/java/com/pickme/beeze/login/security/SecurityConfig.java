package com.pickme.beeze.login.security;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import com.pickme.beeze.login.jwt.JwtTokenFilter;
import com.pickme.beeze.login.jwt.JwtTokenProvider;

//@RequiredArgsConstructor	// @Autowired 사용 안해도됨
@EnableWebSecurity
@Configuration
public class SecurityConfig{

	// 먼저 첫번째 설정 입니다.
	SecurityService service;
	JwtTokenFilter filter;
	JwtTokenProvider provide;

    // 생성자
    public SecurityConfig(JwtTokenFilter filter, JwtTokenProvider provide, 
                                  SecurityService service){
		System.out.println("SecurityConfig(생성자) " + new Date());
		
		this.service = service;
		this.filter = filter;
		this.provide = provide;		
	}
    
	@Bean // api요청시 보안관련 빈 설정
    AuthenticationManager authenticationManager(
    AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
	// 해당 인코더를 설정하지 않으면 만들어준 시큐리티서비스(service)에서 비밀번호 암호화 할 때 오류가 발생 합니다.
    @Bean
	PasswordEncoder passwordEncoder() { 
    	System.out.println("passwordEncoder(SecurityConfig) " + new Date());
		return new BCryptPasswordEncoder();  
	}
    
    // 시큐리티설정, jwt 설정
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, CorsFilter corsFilter) throws Exception {
    	System.out.println("filterChain(SecurityConfig) " + new Date());
     
    	//#1. 요청에 대한 권한설정. (permit:허용, authenticate:증명[토큰만 있으면 가능], hasRole("내용")[해당권한가능])
        http.csrf(AbstractHttpConfigurer::disable)
        	.addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
        	.authorizeHttpRequests((authorize) -> authorize
//        	.requestMatchers("api/v1/mypage/*").authenticated()
        	.requestMatchers("api/v1/user/test").authenticated()
        	.anyRequest().permitAll()
//        	.requestMatchers("/test", "/test1").authenticated()	// 이렇게 해도 된다        	
        );
         	
        //#2. 세션을 사용하지 않습니다.        
        http.sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        //#3. UsernamePasswordAuthenticationFilter 가 동작하기 이전에 JWT 필터를 쓰겠다고 설정하여 줍니다.
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		
        //#4. 사용자 인증 처리 컴포넌트 서비스 등록
        http.userDetailsService(service);
        
    	return http.build();
    }
}
