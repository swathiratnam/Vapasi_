package com.kt.service;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.logging.Logger;

public class SettlementServiceImpl implements SettlementService {
    Logger log = Logger.getLogger("SettlementServiceImpl.class");

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
