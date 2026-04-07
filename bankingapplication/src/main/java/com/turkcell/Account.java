package com.turkcell;

public class Account {
    private String accountNumber;
    private String firstName;
    private String lastName;
    private double balance;    
    
    private String[] transactionHistory = new String[50]; 
    private int transactionCount = 0;

    public Account(String accountNumber, String firstName, String lastName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = initialDeposit;
        addTransaction("Hesap oluşturuldu. İlk bakiye: " + initialDeposit + " TL");
    }

    public String getAccountNumber() { 
        return accountNumber; 
    }
    public String getFirstName() { 
        return firstName; 
    }
    public String getLastName() { 
        return lastName; 
    }
    public String getFullName() { 
        return firstName + " " + lastName; 
    }
    public double getBalance() { 
        return balance; 
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; 
            addTransaction(amount + " TL yatırıldı. Yeni bakiye: " + balance + " TL");
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
        if (transactionCount < transactionHistory.length) { //Sınır kontrolü
            transactionHistory[transactionCount] = message;
            transactionCount++;
        }
    }

    public void printHistory() {
        System.out.println("\n--- " + getFullName() + " İşlem Geçmişi ---");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println("- " + transactionHistory[i]);
        }
        System.out.println("----------------------------\n");
    }
}
