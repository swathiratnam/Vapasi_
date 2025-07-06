package com.kt.util;

import com.kt.model.Expenses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.util.List;

class ExpenseFileReaderTest {

    @Test
    void testReadExpenseFromFile() {

        List<Expenses> expenses = ExpenseFileReader.readExpenseFromFile();
        assertNotNull(expenses);
        assertEquals(3, expenses.size());

        Expenses first = expenses.get(0);
        assertEquals("A", first.getPaidBy());
        assertEquals(100, first.getAmount());
        assertEquals(List.of("A", "B", "C", "D"), first.getSpentOn());

        Expenses second = expenses.get(1);
        assertEquals("B", second.getPaidBy());
        assertEquals(500, second.getAmount());
        assertEquals(List.of("C", "D"), second.getSpentOn());

        Expenses third = expenses.get(2);
        assertEquals("D", third.getPaidBy());
        assertEquals(300, third.getAmount());
        assertEquals(List.of("A", "B"), third.getSpentOn());

    }

}