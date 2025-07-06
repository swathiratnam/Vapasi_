package com.kt.dao;

import java.util.Map;

public interface ExpenseDao {
    // List<Expenses> readExpenseFromFile(String filePath);

   Map<String, Double> calculateExpenses(String filePath);

    void settleExpenses(Map<String,Double> netBalanceList);

}
