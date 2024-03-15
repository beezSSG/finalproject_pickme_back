package com.pickme.beeze.ceo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.ceo.dao.CeoDao;
import com.pickme.beeze.ceo.dto.CeoParam;
import com.pickme.beeze.ceo.dto.PurchaseDto;

@Service
@Transactional
public class CeoService {
	
	@Autowired
	CeoDao dao;
	
	public List<PurchaseDto> poList(CeoParam param) {
		return dao.polist(param);	
	}

	public int getallceo(CeoParam param) {
		return dao.getallceo(param);
	}
	
	public boolean powrite(PurchaseDto po) { 
		return dao.powrite(po)>0?true:false;
	 }

}
