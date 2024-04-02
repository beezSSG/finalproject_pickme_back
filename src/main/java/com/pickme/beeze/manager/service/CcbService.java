package com.pickme.beeze.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pickme.beeze.manager.dao.CcbDao;
import com.pickme.beeze.manager.dto.CcbDto;
import com.pickme.beeze.manager.dto.CcbParam;
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
	// 관리자 카테고리 별 문의 글 개수
	public List<CcbParam> ccbcategorycount(CcbDto dto) {
		return dao.ccbcategorycount(dto);
	}
	// 1:1 문의 게시글 상세보기
	public CcbDto ccbdetail(int id) {
		return dao.ccbdetail(id);
	}
	// 1:1 문의 게시글 지우기
	public void ccbdelete(int id) {
		dao.ccbdelete(id);
	}
	// 1:1 문의 댓글 보기
	public List<CcbaDto> ccbcommentlist(int ccbId) {
		return dao.ccbcommentlist(ccbId);
	}
	// 1:1 문의 관리자 댓글 달기
	public void ccbcommentwrtie(CcbaDto dto) {
		dao.ccbcommentwrite(dto);
	}
	// 1:1 문의 관리자 댓글 단 후 상태 변경
	public void ccbcommentwriteAf(CcbaDto dto) {
		dao.ccbcommentwriteAf(dto);
	}
	// 1:1 문의 관리자 댓글 삭제 후 상태 변경
	public void ccbcommentdeleteAf(CcbaDto dto) {
		dao.ccbcommentdeleteAf(dto);
	}
	// 1:1 문의 관리자 댓글 삭제
	public void ccbcommentdelete(int id) {
		dao.ccbcommentdelete(id);
	}
	// 1:1 답변 안된 리스트 개수
	public int notanswercount(CcbDto dto) {
		return dao.notanswercount(dto);
	}
}
