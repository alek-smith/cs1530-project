package common;
import java.math.BigDecimal;

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
	
}