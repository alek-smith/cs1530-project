package gui;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class AddExpenseToCategoryWizard extends JPanel {

    public AddExpenseToCategoryWizard() {

    }
	
	public static String promptExpense(){
		String s  = JOptionPane.showInputDialog("Enter the name of the expense");
		return s;
	}
	
	public static String promptCategory(){
		String s  = JOptionPane.showInputDialog("What category do you want to add the expense too");
		return s;
	}

}