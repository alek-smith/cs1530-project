package gui;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class GoalWizard extends JPanel {

    public GoalWizard() {

    }
	
	public static String promptGoalName(){
		String s  = JOptionPane.showInputDialog("Enter the name of the goal");
		return s;
	}
	
	public static String promptGoalAmount(){
		String s  = JOptionPane.showInputDialog("Enter the total amount of money needed for the goal");
		return s;
	}
	
	public static String promptGoalContribution(){
		String s  = JOptionPane.showInputDialog("Enter how much money per month you will be putting towards the goal");
		return s;
	}

}
