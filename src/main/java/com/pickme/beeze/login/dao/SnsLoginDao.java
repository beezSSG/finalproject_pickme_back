package com.pickme.beeze.login.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.login.dto.SnsLoginDto;

@Mapper
@Repository
public interface SnsLoginDao {

    int findBySnsId(SnsLoginDto dto);

    void insertSnsId(SnsLoginDto dto);

}