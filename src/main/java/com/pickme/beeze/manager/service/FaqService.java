package com.pickme.beeze.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.manager.dao.FaqDao;
import com.pickme.beeze.manager.dto.FaqDto;
import com.pickme.beeze.manager.dto.FaqParam;

@Service
@Transactional
public class FaqService {

	@Autowired
	FaqDao dao;
	
	// faq 목록 (카테고리 별 불러오기)
	public List<FaqDto> faqlist(FaqParam param) {
		return dao.faqlist(param);
	}
	// faq 생성
	public boolean faqcreate(FaqDto dto) {
		int count = dao.faqcreate(dto);
		return count>0?true:false;
	}
	// faq 삭제
	public boolean faqdelete(int id) {
		int count = dao.faqdelete(id);
		return count>0?true:false;
	}
	// faq 조회수
	public void faqreadcount(int id) {
		dao.faqreadcount(id);
	}
	// top faq 리스트
	public List<FaqDto> topfaqlist(FaqDto dto) {
		return dao.topfaqlist(dto);
	}
}
