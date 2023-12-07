package gui;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class ExpenseCategoryWizard extends JPanel {

    public ExpenseCategoryWizard() {

    }
	
	public static String promptExpenseCategoryName(){
		String s  = JOptionPane.showInputDialog("Enter the name of the category");
		return s;
	}

}
