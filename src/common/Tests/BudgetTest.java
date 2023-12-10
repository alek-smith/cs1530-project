import static org.junit.Assert.*;
import org.junit.*;

import common.Budget;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class BudgetTest {

    @Test
    public void testAddExpense() {
        Budget budget = new Budget();
        budget.addExpense("100", "Groceries", false);
        
        assertEquals(1, budget.expenses.size());
        assertEquals(new BigDecimal("100"), budget.expenses.get(0).getAmount());
        assertFalse(budget.expenses.get(0).isOneTime());
    }

    @Test
    public void testSetNetIncome() {
        Budget budget = new Budget();
        budget.setNetIncome("2000");

        assertEquals(new BigDecimal("2000"), budget.netIncome);
    }

    @Test
    public void testSetSavings() {
        Budget budget = new Budget();
        budget.setSavings("500");

        assertEquals(new BigDecimal("500"), budget.savings);
    }

    @Test
    public void testAddGoal() {
        Budget budget = new Budget();
        budget.addGoal("Vacation", "1000", "500");

        assertEquals(1, budget.goals.size());
        assertEquals(new BigDecimal("1000"), budget.goals.get(0).getAmount());
        assertEquals(new BigDecimal("500"), budget.goals.get(0).getContribution());
    }

    @Test
    public void testNewCategory() {
        Budget budget = new Budget();
        budget.newCategory("Entertainment");

        assertEquals(2, budget.categories.size()); 
        assertEquals("Entertainment", budget.categories.get(1).getName());
    }

    @Test
    public void testAddExpenseToCategory() {
        Budget budget = new Budget();
        budget.addExpense("50", "Dinner", false);
        budget.newCategory("Food");
        budget.addExpenseToCategory("Dinner", "Food");

        assertEquals(1, budget.categories.get(1).getExpenses().size());
        assertEquals("Dinner", budget.categories.get(1).getExpenses().get(0).getName());
    }

    @Test
    public void testLoadAndSave() throws Exception {
        Budget originalBudget = new Budget();
        originalBudget.setNetIncome("3000");
        originalBudget.newCategory("Entertainment");
        originalBudget.addExpenseToCategory("Groceries", "Entertainment");

        File file = new File("testBudget.txt");

        try (PrintWriter writer = new PrintWriter(file)) {
            originalBudget.save(writer);
        }

        Budget loadedBudget = new Budget();
        try (Scanner scanner = new Scanner(file)) {
            loadedBudget.load(scanner);
        }

        assertEquals(originalBudget.netIncome, loadedBudget.netIncome);
        assertEquals(originalBudget.categories.size(), loadedBudget.categories.size());
    }
}