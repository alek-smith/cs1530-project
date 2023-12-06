package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


import java.util.*;
import common.*;

   


public class MainMenu extends JPanel {

	public static Budget budget = new Budget();

    JButton createBudgetButton;
    JButton newExpenseButton;
    JButton newGoalButton;
    JButton newExpenseCategoryButton;
    JButton viewOverviewButton;

    public MainMenu() {

        createBudgetButton = new JButton("Create budget");
        newExpenseButton = new JButton("Track a new expense");
        newGoalButton = new JButton("Set a new goal");
        newExpenseCategoryButton = new JButton("Add a new expense category");
        viewOverviewButton = new JButton("View financial overview");

        add(createBudgetButton);
        add(newExpenseButton);
        add(newGoalButton);
        add(newExpenseCategoryButton);
        add(viewOverviewButton);

        initButtons();

    }

    private void initButtons() {

        createBudgetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
				String ni = BudgetWizard.promptNetIncome();
				budget.setNetIncome(ni);
				
				String s = BudgetWizard.promptSavings();
				budget.setSavings(s);
				
                System.out.println("create budget button pressed!");
            }

        });

        newExpenseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
				
				String name = ExpenseWizard.promptExpenseName();
				String amount = ExpenseWizard.promptExpenseAmount();
				String a = ExpenseWizard.promptExpenseOneTime();
				boolean ot;
				while(true){
					if(a.equals("Y")){
						ot = true;
						break;
					}
					if(a.equals("N")){
						ot = false;
						break;
					}
					a = ExpenseWizard.promptExpenseOneTime();
				}
				
				budget.addExpense(amount, name, ot);
				//budget.printExpense();
                //System.out.println("new expense button pressed!");
            }

        })  ;

        newGoalButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                System.out.println("new goal button pressed!");
            }

        });

        newExpenseCategoryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                System.out.println("new expense category button pressed!");
            }

        });

        viewOverviewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                System.out.println("view overview button pressed!");
            }

        });

    }

}
