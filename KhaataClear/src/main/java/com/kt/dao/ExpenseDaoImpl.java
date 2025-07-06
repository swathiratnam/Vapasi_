package com.kt.dao;

import com.kt.entity.Expenses;
import com.kt.util.ExpenseFileReader;

import java.util.*;
import java.util.logging.Logger;

public class ExpenseDaoImpl implements ExpenseDao {

    Logger log = Logger.getLogger("Expense List");
   /* @Override
    public List<Expenses> readExpenseFromFile(String filePath) {
        return ExpenseFileReader.readExpenseFromFile(filePath);
    }*/

    @Override
    public Map<String, Double> calculateExpenses(String filePath) {
        List<Expenses> expensesList = ExpenseFileReader.readExpenseFromFile(filePath);
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

        return balanceSheet;
    }

    @Override
    public void settleExpenses(Map<String, Double> netBalanceList) {

        PriorityQueue<Map.Entry<String, Double>> creditors = new PriorityQueue<>(
                (a, b) -> Double.compare(b.getValue(), a.getValue()));
        PriorityQueue<Map.Entry<String, Double>> debtors = new PriorityQueue<>(
                (a, b) -> Double.compare(a.getValue(), b.getValue()));
        for (Map.Entry<String, Double> entry : netBalanceList.entrySet()) {
            if (entry.getValue() > 0) {
                creditors.offer(entry);
            } else if (entry.getValue() < 0) {
                debtors.offer(entry);

            }
        }

        while (!creditors.isEmpty() && !debtors.isEmpty()) {

            Map.Entry<String, Double> credit = creditors.poll();
            Map.Entry<String, Double> debit = debtors.poll();

            assert debit != null;
            double settlementAmount = Math.min(credit.getValue(), -debit.getValue());
            log.info(debit.getKey() + " Pays " + credit.getKey() + "  " + (int) settlementAmount);

            credit.setValue(credit.getValue() - settlementAmount);
            debit.setValue(debit.getValue() + settlementAmount);


            if (credit.getValue() > 0) creditors.offer(credit);
            if (debit.getValue() < 0) debtors.offer(debit);

        }


    }
}
