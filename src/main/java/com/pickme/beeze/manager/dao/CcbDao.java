package com.pickme.beeze.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.manager.dto.CcbDto;
import com.pickme.beeze.manager.dto.CcbParam;
import com.pickme.beeze.manager.dto.CcbaDto;

@Mapper
@Repository
public interface CcbDao {
	
	// 1:1 문의
	
	// 1:1 문의 게시글 목록
	List<CcbDto> ccblist(CcbDto dto);
	// 관리자 카테고리 별 문의 글 개수
	List<CcbParam> ccbcategorycount(CcbDto dto);
	// 1:1 문의 게시글 상세보기
	CcbDto ccbdetail(int id);
	// 1:1 문의 게시글 지우기
	void ccbdelete(int id);
	// 1:1 문의 관리자 댓글 보기
	List<CcbaDto> ccbcommentlist(int ccbId);
	// 1:1 문의 관리자 댓글 달기
	void ccbcommentwrite(CcbaDto dto);
	// 1:1 문의 관리자 댓글 단 후 상태 변경
	void ccbcommentwriteAf(CcbaDto dto);
	// 1:1 문의 관리자 댓글 삭제 후 상태 변경
	void ccbcommentdeleteAf(CcbaDto dto);
	// 1:1 문의 관리자 댓글 삭제
	void ccbcommentdelete(int id);
	// 1:1 문의 답변 안된 리스트 개수
	int notanswercount(CcbDto dto);
	
}
