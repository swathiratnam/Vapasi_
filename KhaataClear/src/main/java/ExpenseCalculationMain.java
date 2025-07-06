import com.kt.service.ExpenseServiceImpl;
import com.kt.service.SettlementService;
import com.kt.service.SettlementServiceImpl;
import com.kt.util.ExpenseFileReader;

import java.util.Map;

public class ExpenseCalculationMain {
    public static void main(String[] args) {

        ExpenseServiceImpl expenseDao = new ExpenseServiceImpl(new ExpenseFileReader());
        Map<String, Double> expense = expenseDao.calculateExpenses("expense.txt");
        SettlementService service = new SettlementServiceImpl();
        service.settleExpenses(expense);

    }
}
