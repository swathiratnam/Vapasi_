import com.kt.dao.ExpenseDaoImpl;

import java.util.Map;

public class ExpenseCalculationMain {
    public static void main(String[] args) {
        String path = "/Users/swathibachu/IdeaProjects/myFirstProject/KhaataClear/src/main/resources/expense.txt";
        ExpenseDaoImpl expenseDao = new ExpenseDaoImpl();
        //expenseDao.settleExpenses(path);
        Map<String, Double> balanceSheet = expenseDao.calculateExpenses(path);
        expenseDao.settleExpenses(balanceSheet);
    }
}
