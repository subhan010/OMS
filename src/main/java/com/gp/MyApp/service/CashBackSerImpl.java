package com.gp.MyApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.MyApp.dao.CashBackDAO;
import com.gp.MyApp.ent.CashBack;

@Service
public class CashBackSerImpl implements CashBackServices {

	@Autowired
	private CashBackDAO cbdao;
	
	@Override
	public CashBack getCashback(String email) {
		
		
		return cbdao.findById(email).orElse(null);
	}

	

}
