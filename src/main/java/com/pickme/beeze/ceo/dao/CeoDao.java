package com.pickme.beeze.ceo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.ceo.dto.CeoParam;
import com.pickme.beeze.ceo.dto.ProductDto;
import com.pickme.beeze.ceo.dto.PurchaseDto;

@Mapper
@Repository
public interface CeoDao {
	
	List<PurchaseDto> polist(CeoParam param);
	int getallceo(CeoParam param);
	
	List<ProductDto> powrite(CeoParam param);
	List<ProductDto> powriteCn(ProductDto dto);
	
	int deleteProduct(int id);
	
}
