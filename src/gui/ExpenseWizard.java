package gui;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import gui.MainMenu;

public class ExpenseWizard extends JPanel {

    public ExpenseWizard() {
		
    }
	
	public static String promptExpenseName(){
		String s  = JOptionPane.showInputDialog("Enter the name of the expense");
		return s;
	}
	
	public static String promptExpenseAmount(){
		String s  = JOptionPane.showInputDialog("Enter the amount of the expense");
		return s;
	}
	
	public static String promptExpenseOneTime(){
		String s  = JOptionPane.showInputDialog("Is it a one-time expense Y/N");
		return s;
	}

}