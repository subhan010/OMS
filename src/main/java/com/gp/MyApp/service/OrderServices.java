package com.gp.MyApp.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.gp.MyApp.ent.CashBack;
import com.gp.MyApp.ent.Orders;

public interface OrderServices  {
	
	
	public List<Orders> getOrder(String email);
	public Orders setOrder(String email,Orders ord);

}
