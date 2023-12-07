package common;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Goal{

	private String name;
	private BigDecimal goalAmount;
	private BigDecimal monthlyContribution;
	
	public Goal(String s, BigDecimal amount, BigDecimal mc){
		name = s;
		goalAmount = amount;
		monthlyContribution = mc;
	}
	
	public String getName(){
		return name;
	}
	
	public BigDecimal getAmount(){
		return goalAmount;
	}
	
	public BigDecimal getContribution(){
		return monthlyContribution;
	}

	public void load(Scanner input) {
		String line = input.nextLine();
		name = line;
		line = input.nextLine();
		goalAmount = new BigDecimal(line);
		line = input.nextLine();
		monthlyContribution = new BigDecimal(line);
	}

	public void save(PrintWriter output) {
		output.println(name);
		output.println(goalAmount);
		output.println(monthlyContribution);
	}
	
}