package com.example.qltccn;


public class Expense {
    private String name;
    private String date;
    private String amount;

    public Expense(String name, String date, String amount) {
        this.name = name;
        this.date = date;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getAmount() {
        return amount;
    }
}