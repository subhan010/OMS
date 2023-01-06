package com.gp.MyApp.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.MyApp.ent.CashBack;
import com.gp.MyApp.ent.Customer;
import com.gp.MyApp.ent.Orders;
import com.gp.MyApp.service.CustomerServices;
import com.gp.MyApp.service.OrderServices;
import com.gp.MyApp.service.CashBackServices;

@RestController
public class AppController {
	///get customer information
		public String  pubemail;
		
		@Autowired
		private OrderServices osi;
		
		@Autowired
		private CustomerServices csi;
		
		
		@Autowired
		private CashBackServices cbsi;
		
		//cron job to send mail 
		@Scheduled(fixedRate = 10000)
		   
		   public void emailfeeds() {
			
			if(pubemail!=null)
			{
				int count=csi.getCustomer(pubemail).getNo_of_orders();
				
				if(count<10)
				{
				    System.out.println("Do more "+(10-count)+" order to reach gold tier");	
				}
				else if(count >=10 && count <20)
				{
					System.out.println("Do more "+(10-count)+" order to reach paltinum tier");	
				}
			}
		
		
		
		}
		
		@GetMapping("/customer/{cemail}")
		public Customer getCustomer(@PathVariable String cemail)
		{
		//csi.getCustomer(cemail);
			
			return  csi.getCustomer(cemail);
		}
		///add customer information to database
		@PostMapping("/customer")
		public Customer addCustomer(@RequestBody Customer cus)
		{
			
			return csi.addCustomer(cus);
		}
		
		
		
		@GetMapping("/login/{cemail}")
		public String setlogin(@PathVariable String cemail)
		{
		//csi.getCustomer(cemail);
			
		    
		    pubemail=cemail;
		   
			return "Logged in successfull";
			
		}
		@GetMapping("/logout")
		public String logout()
		{
		
			pubemail=null;
		   
			return "Logged out successfull";
		}
		
		
		
		@GetMapping("/order")
		public List<Orders> getOrder()
		{
		
			return osi.getOrder(pubemail);
		}
		///add customer information to database
		@PostMapping("/order")
		public Orders setorder(@RequestBody Orders ord)
		{
			//cbsi.setCashback();
			System.out.println(pubemail);
			return osi.setOrder(pubemail,ord);
		}
		
		
		@GetMapping("/cashback")
		public CashBack getcashback()
		{
		
			return cbsi.getCashback(pubemail);
		}
		
		
		@GetMapping("/allcustomer")
		public List<Customer> getallcus()
		{
		
			return csi.getallCustomer();
		}
		
		

	
	

}
