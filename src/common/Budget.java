package common;

import java.math.BigDecimal;
import java.util.*;

public class Budget {

    public BigDecimal netIncome;
    public static ArrayList<Expense> expenses = new ArrayList<Expense>();
    public BigDecimal savings;


	public Budget(){
		netIncome = new BigDecimal("0");
		savings = new BigDecimal("0");
	}

	public void addExpense(String a, String n, boolean o){
		expenses.add(new Expense(new BigDecimal(a), o, n));
	}
	
	public void printExpense(){
			for(Expense e : expenses){
				System.out.print(e.getName() + " Amount: " + e.getAmount());
				if(e.isOneTime()){
					System.out.println(" One Time Expense");
				}else{
					System.out.println(" Monthly Expense");
				}
			}
	}
	
	public void setNetIncome(String s){
		netIncome = new BigDecimal(s);
	}
	
	public void setSavings(String s){
		savings = new BigDecimal(s);
	}
}
