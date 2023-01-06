package com.gp.MyApp.ent;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private String cemail;
	private String cname;
	private String membership_type;
	private int no_of_orders;
	
	
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMembership_type() {
		return membership_type;
	}
	public void setMembership_type(String membership_type) {
		this.membership_type = membership_type;
	}
	public int getNo_of_orders() {
		return no_of_orders;
	}
	public void setNo_of_orders(int no_of_orders) {
		this.no_of_orders = no_of_orders;
	}
	
	@Override
	public String toString() {
		return "Customer [cemail=" + cemail + ", cname=" + cname + ", membership_type=" + membership_type
				+ ", no_of_orders=" + no_of_orders + "]";
	}
	
	
	
	
	

}
