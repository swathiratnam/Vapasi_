package com.kt.service;

import com.kt.model.Expenses;
import com.kt.util.ExpenseFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ExpenseServiceImplTest {

    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        expenseService = new ExpenseServiceImpl();
    }
    @Test
    void testCalculateExpenses_withSingleExpense() {
        Expenses expense =mock(Expenses.class);
        when(expense.getAmount()).thenReturn(100.0);
        when(expense.getPaidBy()).thenReturn("A");
        when(expense.getSpentOn()).thenReturn(List.of("A", "B", "C", "D"));
        List<Expenses> mockExpenseList = Collections.singletonList(expense);

        try (MockedStatic<ExpenseFileReader> mockedReader = mockStatic(ExpenseFileReader.class)) {
            mockedReader.when(() -> ExpenseFileReader.readExpenseFromFile("expense.txt")).thenReturn(mockExpenseList);

            Map<String, Double> result = expenseService.calculateExpenses("expense.txt");

            // Each person should owe 25.0
            // So A paid 100, owes 25 → net +75
            // B, C, D owe 25 each → net -25
            assertEquals(4, result.size());
            assertEquals(75.0, result.get("A"));
            assertEquals(-25.0, result.get("B"));
            assertEquals(-25.0, result.get("C"));
            assertEquals(-25.0, result.get("D"));
        }
    }
    @Test
    void testCalculateExpenses_NoExpenses() {
        try (MockedStatic<ExpenseFileReader> mocked = mockStatic(ExpenseFileReader.class)) {
            mocked.when(() -> ExpenseFileReader.readExpenseFromFile("non_expense.txt")).thenReturn(new ArrayList<>());

            Map<String, Double> result = expenseService.calculateExpenses("non_expense.txt");

            assertTrue(result.isEmpty());
        }
    }

}