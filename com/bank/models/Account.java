package com.bank.models;

public class Account {
    private String accountNumber;
    protected double balance; // 'protected' allows access within the same package or subclasses

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
}