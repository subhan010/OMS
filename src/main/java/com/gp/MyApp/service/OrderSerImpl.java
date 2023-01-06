package com.gp.MyApp.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDateTime;

import com.gp.MyApp.dao.CashBackDAO;
import com.gp.MyApp.dao.CustomerDAO;
import com.gp.MyApp.dao.OrderDAO;
import com.gp.MyApp.ent.CashBack;
import com.gp.MyApp.ent.Customer;
import com.gp.MyApp.ent.Orders;

@Service
public class OrderSerImpl implements OrderServices {

	@Autowired
	private OrderDAO odao;
	
	@Autowired
	private CustomerDAO cdao;
	
	@Autowired
	private CashBackDAO cbdao;
	
	 
	
	

	@Override
	public List<Orders> getOrder(String nemail) {
		
		
		return odao.findBycemail(nemail);
	}

	@Override
	public Orders setOrder(String nemail, Orders ord) {
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		    String dt=dtf.format(now);
		    dt = dt.replaceAll("[^0-9]", "");
		    
		    
		    Customer pp=cdao.findById(nemail).orElse(null);
		    //update order count of customer
		    
		     pp.setNo_of_orders(pp.getNo_of_orders()+1);
		    
		     if(pp.getNo_of_orders()>=10 && pp.getNo_of_orders()<=20)
		     {
		    	 pp.setMembership_type("Gold");
		     }
		     else if(pp.getNo_of_orders()>=20)
		     {
		    	pp.setMembership_type("Platinum"); 
		     }
		     
		     //set discount
		     CashBack cb= new CashBack();
		     if(pp.getMembership_type().equals("Gold"))
			    {
			    	cb.setCemail(nemail);
			    	cb.setCashback_amount((ord.getAmount()*10)/100);
			    	
			    	cbdao.save(cb);
			    	
			    }
			    else if(pp.getMembership_type().equals("Platinum"))
			    {
			    	cb.setCemail(nemail);
			    	cb.setCashback_amount((ord.getAmount()*20)/100);
			    	cbdao.save(cb);
			    	
			    }
			   
		     
		     cdao.save(pp);
		     
		     
		    ord.setOrderid(dt);
		    ord.setCemail(nemail);
		    
		    odao.save(ord);
		
		
		return ord;
	}
	
	

}
