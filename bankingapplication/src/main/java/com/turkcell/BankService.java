package com.turkcell;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<Account> database = new ArrayList<>(); 

    private int nextAccountNumber = 1000;

    public void createAccount(String firstName, String lastName, String password, double initialDeposit) {
        String newId = String.valueOf(nextAccountNumber++); 
        
        Account newAccount = new Account(newId, firstName, lastName, password, initialDeposit);
        database.add(newAccount);
        
        System.out.println("\nSistem: Hesap başarıyla açıldı!");
        System.out.println("Lütfen UNUTMAYIN! Sistemin size atadığı Hesap Numarası: " + newId);
        System.out.println("Aramıza hoş geldin, " + newAccount.getFullName() + "\n");
    }

    public Account findAccount(String accountId) {
        for (Account acc : database) {
            if (acc.getAccountNumber().equals(accountId)) {
                return acc;
            }
        }
        return null; 
    }

    public Account login(String accountId, String password) {
        Account acc = findAccount(accountId);
        
        if (acc == null) {
            System.out.println("HATA: Sistemde böyle bir hesap bulunmamaktadır!");
            return null;
        }
        
        if (acc.checkPassword(password)) {
            return acc;
        } else {
            System.out.println("HATA: Girdiğiniz şifre yanlış!");
            return null;
        }
    }

    public void transfer(Account sender, String toId, double amount) {
        Account receiver = findAccount(toId);

        if (receiver != null) {
            if (sender.withdraw(amount)) {
                receiver.deposit(amount);
                sender.addTransaction("Transfer Gönderilen: " + receiver.getFullName() + " | Tutar: " + amount + " TL");
                receiver.addTransaction("Transfer Gelen: " + sender.getFullName() + " | Tutar: " + amount + " TL");
                System.out.println("Transfer Başarılı! (" + amount + " TL -> " + receiver.getFullName() + ")");
            } else {
                System.out.println("Sistem Hatası: Yetersiz bakiye!");
            }
        } else {
            System.out.println("Sistem Hatası: Alıcı hesap bulunamadı!");
        }
    }
}
