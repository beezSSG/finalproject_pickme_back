package com.pickme.beeze.ccb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.ccb.dao.CcbDao;
import com.pickme.beeze.ccb.dto.CcbDto;
import com.pickme.beeze.ccb.dto.CcbaDto;


@Service
@Transactional
public class CcbService {

	@Autowired
	CcbDao dao;
	
	
	// 1:1 문의
	
	// 1:1 문의 게시글 목록
	public List<CcbDto> ccblist(CcbDto dto) {
		return dao.ccblist(dto);
	}
	// 1:1 문의 게시글 상세보기
	public CcbDto ccbdetail(int id) {
		return dao.ccbdetail(id);
	}
	// 1:1 문의 관리자 댓글 달기
	public boolean ccbcommentwrtie(CcbaDto dto) {
		int count = dao.ccbcommentwrite(dto);
		return count>0?true:false;
	}
}
