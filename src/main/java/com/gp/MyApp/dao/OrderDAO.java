package com.gp.MyApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gp.MyApp.ent.Orders;

import java.util.*;

@Repository
public interface OrderDAO extends JpaRepository<Orders,String> {
	List<Orders> findBycemail(String email);
}
