package com.example.qltccn;

import com.google.firebase.Timestamp;

public class Expense {
    private String name;
    private double amount;
    private Timestamp date;
    private String category;

    public Expense() {
        // Constructor mặc định cần thiết cho Firestore
    }

    public Expense(String name, double amount, Timestamp date, String category) {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    // Getters và Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}