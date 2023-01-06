package com.gp.MyApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.MyApp.dao.CustomerDAO;
import com.gp.MyApp.ent.Customer;

@Service
public class CustomerServicesImplementation implements CustomerServices {

	@Autowired
	private CustomerDAO cdao;
	@Override
	public Customer getCustomer(String email) {
		// TODO Auto-generated method stub
		
		return cdao.findById(email).orElse(null);
	}

	@Override
	public Customer addCustomer(Customer cus) {
		// TODO Auto-generated method stub
		cus.setMembership_type("Regular");
		cus.setNo_of_orders(0);
		cdao.save(cus);
		return cus;
	}

	@Override
	public List<Customer> getallCustomer() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}

}
