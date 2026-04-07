package com.turkcell;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<Account> database = new ArrayList<>(); //Hesapları sınırsız tutmak için ArrayList kullandık

    public void createAccount(String accountNumber, String firstName, String lastName, double initialDeposit) {
        Account newAccount = new Account(accountNumber, firstName, lastName, initialDeposit);
        
        database.add(newAccount);
        
        System.out.println("Hesap başarıyla açıldı -> " + newAccount.getFullName());
    }

    public Account findAccount(String accountId) {
        for (Account acc : database) {
            if (acc.getAccountNumber().equals(accountId)) {//string karşılaştırması için equals kullanılır
                return acc;
            }
        }
        return null; 
    }

    public void transfer(String fromId, String toId, double amount) {
        Account sender = findAccount(fromId);
        Account receiver = findAccount(toId);

        if (sender != null && receiver != null) {
            if (sender.withdraw(amount)) {
                receiver.deposit(amount);
                
                sender.addTransaction("Transfer Gönderilen: " + receiver.getFullName() + " | Tutar: " + amount + " TL");
                receiver.addTransaction("Transfer Gelen: " + sender.getFullName() + " | Tutar: " + amount + " TL");
                
                System.out.println("Transfer Başarılı: " + sender.getFullName() + " -> " + receiver.getFullName() + " (" + amount + " TL)");
            } else {
                System.out.println("Transfer Başarısız: Yetersiz bakiye!");
            }
        } else {
            System.out.println("Transfer Başarısız: Hesap bulunamadı!");
        }
    }

    public void printAccountHistory(String accountId) {
        Account acc = findAccount(accountId);
        if (acc != null) {
            acc.printHistory();
        }
    }
}
