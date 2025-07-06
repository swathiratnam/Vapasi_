package com.kt.service;

import java.util.Map;

public interface SettlementService {
    void settleExpenses(Map<String, Double> netBalanceList);
}
