package com.bank.services;
import com.bank.models.Account; // Dependency Import

public class TransactionProcessor {
    public static void deposit(Account account, double amount) {
        System.out.println("Depositing $" + amount + " to " + account.getAccountNumber());
        // In a real app, we'd have a method to update balance
    }
}
