package com.gp.MyApp.service;


import java.util.List;

import com.gp.MyApp.ent.Customer;


public interface CustomerServices {
	
        public Customer getCustomer(String email);
        public Customer addCustomer(Customer customer);
        public List<Customer> getallCustomer();



}
