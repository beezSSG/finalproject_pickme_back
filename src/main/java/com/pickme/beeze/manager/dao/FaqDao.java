package com.pickme.beeze.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.manager.dto.FaqDto;
import com.pickme.beeze.manager.dto.FaqParam;

@Mapper
@Repository
public interface FaqDao {
	
	// faq 목록 (카테고리 별 불러오기)
	List<FaqDto> faqlist(FaqParam param);
	// faq 생성
	int faqcreate(FaqDto dto);
	// faq 삭제
	int faqdelete(int id);
	// faq 조회수
	void faqreadcount(int id);
	// top faq 리스트
	List<FaqDto> topfaqlist(FaqDto dto);

}
