package com.kt.util;

import com.kt.entity.Expenses;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseFileReader {

    public static List<Expenses> readExpenseFromFile() {

        List<Expenses> expensesList = new ArrayList<>();
        InputStream inputStream = ExpenseFileReader.class.getClassLoader().getResourceAsStream("expense.txt");
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found!");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
                //Formating A spent 100 for Snacks for A, B, C, D
                String[] parts = line.split("spent");
                String paidBy = parts[0].trim();

                String[] rest = parts[1].split("for");
                int amount = Integer.parseInt(rest[0].trim());

                String[] afterSecondFor = parts[1].split("for", 3);
                String spentOnStr = afterSecondFor[2].trim();

                String[] spentOArray = spentOnStr.split(",");

                List<String> spentOnList = new ArrayList<>();
                for (String spentOn : spentOArray) {
                    spentOnList.add(spentOn.trim());
                }

                expensesList.add(new Expenses(amount, paidBy, spentOnList));

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return expensesList;

    }


}
