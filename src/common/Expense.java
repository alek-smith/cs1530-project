package common;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

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

	public void load(Scanner input) {
		String line = input.nextLine();
		amount = new BigDecimal(line);
		line = input.nextLine();
		oneTime = Boolean.parseBoolean(line);
		line = input.nextLine();
		name = line;
	}

	public void save(PrintWriter output) {
		output.println(amount);
		output.println(oneTime);
		output.println(name);
	}

}