package com.turkcell;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String password; 
    private double balance;
    
    private List<String> transactionHistory = new ArrayList<>(); 

    public Account(String accountNumber, String firstName, String lastName, String password, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.balance = initialDeposit;
        addTransaction("Hesap oluşturuldu. İlk bakiye: " + initialDeposit + " TL");
    }

    public String getAccountNumber() { return accountNumber; }
    public String getFullName() { return firstName + " " + lastName; }
    public double getBalance() { return balance; }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; 
            addTransaction(amount + " TL yatırıldı. Yeni bakiye: " + balance + " TL");
            System.out.println("Para başarıyla yatırıldı.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            addTransaction(amount + " TL çekildi. Kalan bakiye: " + balance + " TL");
            return true;
        }
        return false; 
    }

    public void addTransaction(String message) {
        transactionHistory.add(message);
    }

    public void printHistory() {
        System.out.println("\n--- " + getFullName() + " İşlem Geçmişi ---");
        for (String record : transactionHistory) {
            System.out.println("- " + record);
        }
        System.out.println("----------------------------\n");
    }
    
    public void printAccountInfo() {
        System.out.println("\n--- Hesap Bilgileri ---");
        System.out.println("Hesap No : " + accountNumber);
        System.out.println("Ad Soyad : " + getFullName());
        System.out.println("Bakiye   : " + balance + " TL");
        System.out.println("-----------------------\n");
    }
}
