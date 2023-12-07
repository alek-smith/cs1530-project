package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


import java.util.*;
import common.*;

   


public class MainMenu extends JPanel {

	public Budget budget = new Budget();

    JButton createBudgetButton;
    JButton newExpenseButton;
    JButton newGoalButton;
    JButton newExpenseCategoryButton;
    JButton viewOverviewButton;
	JButton addExpensetoCategoryButton;

    public MainMenu() {

        createBudgetButton = new JButton("Create budget");
        newExpenseButton = new JButton("Track a new expense");
        newGoalButton = new JButton("Set a new goal");
        newExpenseCategoryButton = new JButton("Add a new expense category");
        viewOverviewButton = new JButton("View financial overview");
		addExpensetoCategoryButton = new JButton("Add Expense to an Expense Category");

        add(createBudgetButton);
        add(newExpenseButton);
        add(newGoalButton);
        add(newExpenseCategoryButton);
        add(viewOverviewButton);
		add(addExpensetoCategoryButton);

        initButtons();

    }

    public void load(Scanner input) {
        budget.load(input);
    }

    public void save(PrintWriter output) {
        budget.save(output);
    }

    private void initButtons() {

        createBudgetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
				String ni = BudgetWizard.promptNetIncome();
				budget.setNetIncome(ni);
				
				String s = BudgetWizard.promptSavings();
				budget.setSavings(s);
				
                //System.out.println("create budget button pressed!");
            }

        });

        newExpenseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
				
				String name = ExpenseWizard.promptExpenseName();
                if (name == null) return;
				String amount = ExpenseWizard.promptExpenseAmount();
                if (amount == null) return;
				String a = ExpenseWizard.promptExpenseOneTime();
                if (a == null) return;
				boolean ot;
				while(true){
					if(a.toLowerCase().equals("y")){
						ot = true;
						break;
					}
					if(a.toLowerCase().equals("n")){
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
				String n = GoalWizard.promptGoalName();
                if (n == null) return;
				String a = GoalWizard.promptGoalAmount();
                if (a == null) return;
				String mc = GoalWizard.promptGoalContribution();
                if (mc == null) return;
				
				budget.addGoal(n, a, mc);
				
				
				
                //System.out.println("new goal button pressed!");
            }

        });

        newExpenseCategoryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
				
				
				String s = ExpenseCategoryWizard.promptExpenseCategoryName();
                if (s == null) return;
				budget.newCategory(s);
				
               // System.out.println("new expense category button pressed!");
            }

        });

        viewOverviewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
				
				Overview.showOverview(budget);
                //System.out.println("view overview button pressed!");
            }

        });
		
		        addExpensetoCategoryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
				String ex = AddExpenseToCategoryWizard.promptExpense();
                if (ex == null) return;
				String c = AddExpenseToCategoryWizard.promptCategory();
                if (c == null) return;
				
				budget.addExpenseToCategory(ex, c);
				
                //System.out.println("add expense to category button pressed");
            }

        });

    }

}
