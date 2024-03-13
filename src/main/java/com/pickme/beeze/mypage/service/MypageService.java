package com.pickme.beeze.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.mypage.dao.MypageDao;
import com.pickme.beeze.mypage.dto.MypageSaveDto;

@Service
@Transactional
public class MypageService {
	
	@Autowired
	MypageDao dao;
	
	// 찜
	// 찜생성
	public int addSave(MypageSaveDto dto) {
		return dao.addSave(dto);
	}
	// 찜목록 불러오기
	public List<MypageSaveDto> getSave(){
		return dao.getSave();
	}
	// 찜삭제
	public int delSave(MypageSaveDto dto) {
		return dao.delSave(dto);
	}
}
