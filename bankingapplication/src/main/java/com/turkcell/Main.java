package com.turkcell;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankService();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("**************************************");
        System.out.println("     GYGY BANKASINA HOŞ GELDİNİZ!     ");
        System.out.println("**************************************");

        while (true) {
            System.out.println("\nLütfen yapmak istediğiniz işlemi seçin:");
            System.out.println("1 - Giriş Yap");
            System.out.println("2 - Yeni Hesap Oluştur");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("\nHesap Numaranız: ");
                String accId = scanner.nextLine();
                
                System.out.print("Şifreniz: ");
                String pass = scanner.nextLine();

                // Banka servisinden hesabı getirmesini istiyoruz
                Account loggedInUser = bank.login(accId, pass);

                // Eğer giriş başarılıysa, iç menüye gir
                if (loggedInUser != null) {
                    System.out.println("\nGiriş Başarılı! Hoş geldin, " + loggedInUser.getFullName());
                    
                    boolean isLogged = true;
                    while (isLogged) {
                        System.out.println("\n--- HESAP MENÜSÜ ---");
                        System.out.println("1 - Hesap Bilgilerimi Gör");
                        System.out.println("2 - Para Gönder (Havale/EFT)");
                        System.out.println("3 - İşlem Geçmişimi Görüntüle");
                        System.out.println("4 - Hesaba Para Yatır");
                        System.out.println("0 - Çıkış Yap (Ana Menüye Dön)");
                        System.out.print("İşlem Seçiniz: ");
                        
                        int innerChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (innerChoice) {
                            case 1:
                                loggedInUser.printAccountInfo();
                                break;
                            case 2:
                                System.out.print("Para gönderilecek hesap numarası: ");
                                String targetId = scanner.nextLine();
                                System.out.print("Gönderilecek Tutar: ");
                                double amount = scanner.nextDouble();
                                scanner.nextLine();
                                
                                bank.transfer(loggedInUser, targetId, amount);
                                break;
                            case 3:
                                loggedInUser.printHistory();
                                break;
                            case 4:
                                System.out.print("Yatırılacak Tutar: ");
                                double depAmount = scanner.nextDouble();
                                scanner.nextLine();
                                loggedInUser.deposit(depAmount);
                                break;
                            case 0:
                                System.out.println("Hesaptan çıkış yapılıyor... Ana menüye dönüldü.");
                                isLogged = false; 
                                break;
                            default:
                                System.out.println("Hatalı seçim yaptınız!");
                        }
                    }
                } 

            } else if (choice == 2) {
                System.out.println("\n--- YENİ HESAP OLUŞTURMA ---");
                
                System.out.print("Adınız: ");
                String name = scanner.nextLine();
                
                System.out.print("Soyadınız: ");
                String surname = scanner.nextLine();
                
                System.out.print("Şifre Belirleyin: ");
                String newPass = scanner.nextLine();
                
                System.out.print("Yatırmak İstediğiniz İlk Tutar (TL): ");
                double deposit = scanner.nextDouble();
                scanner.nextLine();

                bank.createAccount(name, surname, newPass, deposit);

            } else if (choice == 0) {
                System.out.println("GYGY Bankasını tercih ettiğiniz için teşekkür ederiz. İyi günler!");
                break; 
            } else {
                System.out.println("Hata: Geçersiz bir seçim yaptınız!");
            }
        }
        
        scanner.close(); 
    }
}
