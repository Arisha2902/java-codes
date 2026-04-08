package com.bank.models;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accNum, double bal, double rate) {
        super(accNum, bal);
        this.interestRate = rate;
    }

    public void applyInterest() {
        balance += balance * interestRate; // Accesses protected 'balance'
    }
}
