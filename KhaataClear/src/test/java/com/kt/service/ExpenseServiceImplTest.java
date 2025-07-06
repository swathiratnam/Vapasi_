package com.kt.service;

import com.kt.util.ExpenseFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class ExpenseServiceImplTest {
    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        ExpenseFileReader expenseFileReader = new ExpenseFileReader();
        expenseService = new ExpenseServiceImpl(expenseFileReader);
    }

    @Test
    public void testCalculateExpenses() {

        Map<String, Double> balance = expenseService.calculateExpenses("expense.txt");
        assertNotNull(balance);
        assertEquals(4,balance.size());
        assertEquals(-75.0,balance.get("A"));
        assertEquals(25.0,balance.get("D"));
        assertEquals(325.0,balance.get("B"));
        assertEquals(-275.0,balance.get("C"));
    }
}