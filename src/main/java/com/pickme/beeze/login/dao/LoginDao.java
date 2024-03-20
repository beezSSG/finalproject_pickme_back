package com.pickme.beeze.login.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.login.dto.LoginDto;

@Mapper
@Repository
public interface LoginDao {

	int addCustomerInfo(LoginDto dto);
	int addCeoInfo(LoginDto dto);
	
	int countCustomerInfo(String email);
	int countCeoInfo(String email);
	
	LoginDto selectCustomerInfo(LoginDto dto);
	LoginDto selectCeoInfo(LoginDto dto);
	LoginDto whoCustomer(LoginDto dto);
	LoginDto whoCeo(LoginDto dto);
	
	LoginDto searchCustomerInfo(int id);
	LoginDto searchCeoInfo(int id);
	
	
	/*
	// jwt 토큰 실험용
	int insertUserToJoin(UserDto dto);
	UserDto selectUserByUserId(String user_id);
	UserDto selectUserAndBranchToInfo(String string);
	int selectCountToFindUserExist(UserDto userDTO);
	int updateUserByUserIdToChgPW(UserDto userDTO);
	*/
	
}
