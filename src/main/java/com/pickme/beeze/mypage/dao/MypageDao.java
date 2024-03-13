package com.pickme.beeze.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.mypage.dto.MypageSaveDto;

@Mapper
@Repository
public interface MypageDao {
	
	// 찜
	// 찜생성
	int addSave(MypageSaveDto dto);
	// 찜목록 불러오기
	List<MypageSaveDto> getSave();
	// 찜삭제
	int delSave(MypageSaveDto dto);
}
