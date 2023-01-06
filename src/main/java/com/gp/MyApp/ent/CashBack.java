package com.gp.MyApp.ent;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CashBack {
	@Id
	private String cemail;
	private long cashback_amount;
	
	
	
	
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public long getCashback_amount() {
		return cashback_amount;
	}
	public void setCashback_amount(long cashback_amount) {
		this.cashback_amount = cashback_amount;
	}
	
	@Override
	public String toString() {
		return "CashBack [cemail=" + cemail + ", cashback_amount=" + cashback_amount + "]";
	}
	
    
}
