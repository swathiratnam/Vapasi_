package com.kt.entity;

import java.util.List;

public class Expenses {

    double amount;
    String paidBy;
    List<String> spentOn;


    public Expenses(double amount, String paidBy, List<String> spentOn) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.spentOn = spentOn;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public List<String> getSpentOn() {
        return spentOn;
    }


    @Override
    public String toString() {
        return "Expenses{" +
                "amount=" + amount +
                ", paidBy='" + paidBy + '\'' +
                ", spentOn=" + spentOn +
                '}';
    }
}
