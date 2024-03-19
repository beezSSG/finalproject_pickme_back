package com.pickme.beeze.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.manager.dto.CcbDto;
import com.pickme.beeze.manager.dto.CcbaDto;

@Mapper
@Repository
public interface CcbDao {
	
	// 1:1 문의
	
	// 1:1 문의 게시글 목록
	List<CcbDto> ccblist(CcbDto dto);
	// 1:1 문의 게시글 상세보기
	CcbDto ccbdetail(int id);
	// 1:1 문의 관리자 댓글 보기
	List<CcbaDto> ccbcommentlist(int ccbId);
	// 1:1 문의 관리자 댓글 달기
	void ccbcommentwrite(CcbaDto dto);
	// 1:1 문의 관리자 댓글 삭제
	void ccbcommentdelete(int id);
	
}
