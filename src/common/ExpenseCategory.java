package common;

import java.io.PrintWriter;
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

	public void load(Scanner input, ArrayList<Expense> list) {
		String line = input.nextLine();
		name = line;
		int size = Integer.parseInt(input.nextLine());
		for (int i = 0; i < size; i++) {
			line = input.nextLine();
			for (int j = 0; j < list.size(); j++) {
				if (line.equals(list.get(j).getName())) expenses.add(list.get(j));
			}
		}
	}

	public void save(PrintWriter output) {
		output.println(name);
		output.println(expenses.size());
		for (Expense e : expenses) output.println(e.getName());
	}

}