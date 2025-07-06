package com.kt.service;

import com.kt.entity.Expenses;
import com.kt.util.ExpenseFileReader;

import java.util.*;

public class ExpenseServiceImpl implements ExpenseService {

    @Override
    public Map<String, Double> calculateExpenses() {
        List<Expenses> expensesList = ExpenseFileReader.readExpenseFromFile();
        Map<String, Double> balanceSheet = new HashMap<>();
        for (Expenses expense : expensesList) {
            double share = expense.getAmount() / expense.getSpentOn().size();
            for (String spentOn : expense.getSpentOn()) {
                balanceSheet.put(spentOn, balanceSheet.getOrDefault(spentOn, 0.0) - share);
            }
            balanceSheet.put(expense.getPaidBy(), balanceSheet.getOrDefault(expense.getPaidBy(), 0.0) + expense.getAmount());
        }

        SettlementServiceImpl service = new SettlementServiceImpl();
        service.settleExpenses(balanceSheet);
        return balanceSheet;
    }
}
