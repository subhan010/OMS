package com.gp.MyApp.ent;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders {

	@Id
	private String orderid;
	
	private String cemail;
	private long amount;
	
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", cemail=" + cemail + ", amount=" + amount + "]";
	}
	
	
	
	
	
}
