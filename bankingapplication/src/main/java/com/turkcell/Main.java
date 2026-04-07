package com.turkcell;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== GYGY Bankasına Hoş Geldiniz ===\n");

        BankService bank = new BankService();

        bank.createAccount("1001", "Ayşe", "Ulaşlı", 50000.0);
        bank.createAccount("1002", "Gizem", "Özcan", 15000.0);

        bank.transfer("1001", "1002", 10000.0);

        bank.printAccountHistory("1001");
        bank.printAccountHistory("1002");
        
    }
}
