package common;

import java.math.BigDecimal;
import java.util.*;

public class Budget {

    public BigDecimal netIncome;
    public static ArrayList<Expense> expenses = new ArrayList<Expense>();
    public BigDecimal savings;
	public static ArrayList<Goal> goals = new ArrayList<Goal>();
	public static ArrayList<ExpenseCategory> categories = new ArrayList<ExpenseCategory>();

	public Budget(){
		netIncome = new BigDecimal("0");
		savings = new BigDecimal("0");
		categories.add(new ExpenseCategory("uncategorized"));
	}

	public void addExpense(String a, String n, boolean o){
		Expense e = new Expense(new BigDecimal(a), o, n);
		expenses.add(e);
		categories.get(0).addExpense(e);
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
	
	public void addGoal(String n, String a, String mc){
		goals.add(new Goal(n, new BigDecimal(a), new BigDecimal(mc)));
	}
	
	public void newCategory(String n){
		categories.add(new ExpenseCategory(n));
	}
	
	public void addExpenseToCategory(String e, String c){
		Expense a = null;
		for(Expense b : expenses){
			if(b.getName().equals(e)){
				a = b;
				break;
			}
		}
		if(a == null){
			return;
		}
		
		
		for(ExpenseCategory xc : categories){
			xc.removeExpense(a);
		}
		
		
		ExpenseCategory ec = null;
		for(ExpenseCategory xc : categories){
			if(xc.getName().equals(c)){
				ec = xc;
				break;
			}
		}
		if(ec == null){
			return;
		}
		
		
		ec.addExpense(a);
	}
}
