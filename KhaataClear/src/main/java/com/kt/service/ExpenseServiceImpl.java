package com.kt.service;

import com.kt.entity.Expenses;
import com.kt.util.ExpenseFileReader;

import java.util.*;
import java.util.logging.Logger;

public class ExpenseServiceImpl implements ExpenseService {

    Logger log = Logger.getLogger("Expense List");

    @Override
    public void calculateExpenses() {
        List<Expenses> expensesList = ExpenseFileReader.readExpenseFromFile();
        Map<String, Double> balanceSheet = new HashMap<>();
        for (Expenses expense : expensesList) {
            double share = expense.getAmount() / expense.getSpentOn().size();
            for (String spentOn : expense.getSpentOn()) {
                balanceSheet.put(spentOn, balanceSheet.getOrDefault(spentOn, 0.0) - share);
                System.out.println(balanceSheet);
            }
            balanceSheet.put(expense.getPaidBy(), balanceSheet.getOrDefault(expense.getPaidBy(), 0.0) + expense.getAmount());
            System.out.println("Balance Sheet : ");
            System.out.println(balanceSheet);
        }

        SettlementService service = new SettlementService();
        service.settleExpenses(balanceSheet);
    }

}
