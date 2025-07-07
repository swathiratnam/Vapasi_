package com.kt.service;

import java.util.List;
import java.util.Map;

public interface SettlementService {
    List<String> settleExpenses(Map<String, Double> netBalanceList);
}
