package com.pickme.beeze.login.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.login.dao.LoginDao;
import com.pickme.beeze.login.dto.LoginDto;

@Service
@Transactional
public class SecurityService implements UserDetailsService {
	
	@Autowired
	LoginDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername(SecurityService) " + new Date());
		
		// DB 확인작업
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		LoginDto memberDto = new LoginDto();
		memberDto.setEmail(email);
		
		// 고객일 경우 세팅
		LoginDto member = dao.whoCustomer(memberDto);
		System.out.println(member.toString());
		member.setRole("customer");
		
		// 점주일 경우 세팅
		if (member.getRdate() == null || member.getRdate().equals("")) {
			member = dao.whoCeo(memberDto);
			member.setRole("ceo");
		}
		System.out.println("LoginDto :: " + member.toString() );
		
		list.add(new SimpleGrantedAuthority(member.getRole()));
		return new org.springframework.security.core.userdetails.User(member.getEmail(), member.getPw(), list);
	}
}