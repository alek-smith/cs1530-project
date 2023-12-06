package common;

import java.math.BigDecimal;

public class Expense {

    private BigDecimal amount;
	private boolean oneTime; // true if the expense is a one-time expense and false if it is a recurring monthly expense
	private String name;
	
	public Expense(BigDecimal a, boolean o, String n){
		amount = a;
		oneTime = o;
		name = n;
	}
	
	public BigDecimal getAmount(){
		return amount;
	}
	
	public boolean isOneTime(){
		return oneTime;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAmount(BigDecimal a){
		amount = a;
	}

}