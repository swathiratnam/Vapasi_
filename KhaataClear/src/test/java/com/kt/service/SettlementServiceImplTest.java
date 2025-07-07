package com.kt.service;

import com.kt.util.ExpenseFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SettlementServiceImplTest {
    private ExpenseService expenseService;
    private SettlementService service;

    @BeforeEach
    void setUp() {
        ExpenseFileReader expenseFileReader = new ExpenseFileReader();
        expenseService = new ExpenseServiceImpl(expenseFileReader);
        service = new SettlementServiceImpl();
    }

    @Test
    void settleExpenses() {
        List<String> setteldList = service.settleExpenses(expenseService.calculateExpenses("expense.txt"));
        assertNotNull(setteldList);
        assertEquals(3,setteldList.size());
        assertEquals("C Pays B  275",setteldList.get(0));
        assertEquals("A Pays B  50",setteldList.get(1));
        assertEquals("A Pays D  25",setteldList.get(2));
    }
}