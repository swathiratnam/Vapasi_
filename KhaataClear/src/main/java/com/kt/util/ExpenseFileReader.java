package com.kt.util;

import com.kt.entity.Expenses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseFileReader {

    public static List<Expenses> readExpenseFromFile(String filePath) {

        List<Expenses> expensesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
                //Formating A spent 100 for Snacks for A, B, C, D
                String[] parts = line.split("spent");
                String paidBy = parts[0].trim();

                String[] rest = parts[1].split("for");
                int amount = Integer.parseInt(rest[0].trim());

                String[] afterSecondFor = parts[1].split("for",3);
                String spentOnStr = afterSecondFor[2].trim();

                String[] spentOArray = spentOnStr.split(",");

                List<String> spentOnList = new ArrayList<>();
                for (String spentOn : spentOArray) {
                    spentOnList.add(spentOn.trim());
                }

                expensesList.add(new Expenses(amount, paidBy, spentOnList));
                System.out.println(expensesList);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return expensesList;

    }


}
