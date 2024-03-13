package com.pickme.beeze.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pickme.beeze.manager.dao.CcbDao;
import com.pickme.beeze.manager.dto.CcbDto;
import com.pickme.beeze.manager.dto.CcbaDto;


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
	// 1:1 문의 관리자 댓글 삭제
	public boolean ccbcommentdelete(int id) {
		int count = dao.ccbcommentdelete(id);
		return count>0?true:false;
	}
}