package com.pickme.beeze.login.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.login.dao.LoginDao;
import com.pickme.beeze.login.dto.LoginDto;

@Lazy
@Service
@Transactional
public class SecurityService implements UserDetailsService {
	
	private final LoginDao dao;

    public SecurityService(LoginDao dao) {
        this.dao = dao;
    }
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername(SecurityService) " + new Date());
		
		// DB 확인작업
		List<SimpleGrantedAuthority> list = new ArrayList<>();	// 권한 부여
		
		// 고객일 경우 세팅
		LoginDto member = dao.whoCustomer(email);
//		System.out.println(member.toString());
		member.setRole("customer");
		
		// 점주일 경우 세팅
		if (member.getRdate() == null || member.getRdate().equals("")) {
			member = dao.whoCeo(email);
			member.setRole("ceo");
		}
		
		// 관리자일 경우 세팅
		
		member.setPw(encoder.encode(member.getPw()));
//		System.out.println("LoginDto :: " + member.toString() );
		
		list.add(new SimpleGrantedAuthority(member.getRole()));
		return new org.springframework.security.core.userdetails.User(member.getEmail(), member.getPw(), list);
	}
}