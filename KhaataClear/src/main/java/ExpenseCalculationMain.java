import com.kt.service.ExpenseServiceImpl;
import com.kt.service.SettlementService;
import com.kt.service.SettlementServiceImpl;
import com.kt.util.ExpenseFileReader;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ExpenseCalculationMain {
    public static void main(String[] args) {

        Logger log = Logger.getLogger(ExpenseCalculationMain.class.getName());
        ExpenseServiceImpl expenseService = new ExpenseServiceImpl(new ExpenseFileReader());
        SettlementService service = new SettlementServiceImpl();
      
        Map<String, Double> expenses = expenseService.calculateExpenses("expense1.txt");
        List<String> settledExpenses = service.settleExpenses(expenses);
      
        for (String s : settledExpenses) {
            log.info(s);
        }
    }
}
