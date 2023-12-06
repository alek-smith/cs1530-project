package gui;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class BudgetWizard extends JPanel {

    public BudgetWizard() {

    }
	
	public static String promptNetIncome(){
		String s  = JOptionPane.showInputDialog("What is your net monthly income");
		return s;
	}
	
	public static String promptSavings(){
		String s  = JOptionPane.showInputDialog("What is your savings");
		return s;
	}

}
