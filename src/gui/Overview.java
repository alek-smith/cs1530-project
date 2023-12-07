package gui;

import javax.swing.JPanel;
import common.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.math.BigDecimal;

public class Overview extends JPanel {

    public Overview() {

    }
	
	public static void showOverview(Budget b){
		BigDecimal totalSpending = new BigDecimal("0");
		StringBuilder s = new StringBuilder();
		s.append("Your total savings are: $");
		s.append("" + b.savings);
		s.append("\n\nYour net monthly income is: $");
		s.append(""+ b.netIncome);
		s.append("\n\n");
		
		//System.out.println(b.categories.size());
		
		for(ExpenseCategory ec : b.categories){
			if(ec.expenses.size() > 0){
				s.append(ec.getName() + "\n");
			}
			for(Expense e : ec.expenses){
				s.append("     " + e.getName() + ": " + e.getAmount());
				totalSpending = totalSpending.add(e.getAmount());
				s.append("\n");
			}
			s.append("\n");
		}
		
		
		for(Goal g : b.goals){
			s.append(g.getContribution().toString() + " per month is going towards "  + g.getName().toString() + ". The total amount for " + g.getName().toString() + " is " + g.getAmount().toString() + "\n");
			totalSpending = totalSpending.add(g.getContribution());
		}
		
		s.append("Your total spending for this month is " + totalSpending);
		
		
		JOptionPane.showMessageDialog(null, s.toString(), "Financial Overview", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
}
