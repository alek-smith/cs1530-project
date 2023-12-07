package common;

import java.util.*;

public class ExpenseCategory {

    private String name;
	public ArrayList<Expense> expenses;
	
	public ExpenseCategory(String n){
		name = n;
		expenses = new ArrayList<Expense>();
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Expense> getExpenses(){
		return expenses;
	}
	
	public void addExpense(Expense e){
		expenses.add(e);
	}
	
	public void removeExpense(Expense e){
		for(int i = 0; i < expenses.size(); i++){
			Expense a = expenses.get(i);
			if(a.getName() == e.getName() && a.getAmount() == e.getAmount()){
				expenses.remove(i);
				break;
			}
		}
		
	}

}