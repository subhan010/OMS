package com.gp.MyApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gp.MyApp.dao.OrderDAO;



@SpringBootTest
class OmsApplicationTests {

	
	
	@Autowired
	private OrderDAO odao;
	
	@Test
	void contextLoads() {
	}
	
	
	
	
	@Test
	void getOrder() {
		String nemail="";
		
	}


}
