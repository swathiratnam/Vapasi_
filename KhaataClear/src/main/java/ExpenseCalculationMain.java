import com.kt.service.ExpenseServiceImpl;

public class ExpenseCalculationMain {
    public static void main(String[] args) {

        ExpenseServiceImpl expenseDao = new ExpenseServiceImpl();
        expenseDao.calculateExpenses();

    }
}
