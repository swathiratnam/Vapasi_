import com.kt.service.ExpenseServiceImpl;
import com.kt.service.SettlementService;
import com.kt.service.SettlementServiceImpl;
import com.kt.util.ExpenseFileReader;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ExpenseCalculationMain {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("ExpenseCalculationMain");
        ExpenseServiceImpl expenseDao = new ExpenseServiceImpl(new ExpenseFileReader());
        Map<String, Double> expense = expenseDao.calculateExpenses("expense1.txt");
        SettlementService service = new SettlementServiceImpl();
        List<String> settledExpenses = service.settleExpenses(expense);
        for (String s : settledExpenses) {
            log.info(s);
        }
    }
}
