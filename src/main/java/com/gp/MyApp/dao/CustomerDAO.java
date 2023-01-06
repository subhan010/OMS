package com.gp.MyApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.MyApp.ent.Customer;

public interface CustomerDAO extends JpaRepository<Customer,String> {

}
