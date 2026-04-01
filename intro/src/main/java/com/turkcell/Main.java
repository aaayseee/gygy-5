package com.turkcell;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Merhaba Turkcell!");
        System.out.println("GYGY 5.0 da görüşmek üzere!");


        System.out.println("***********");


        // Programlama konseptleri

        // Scope Kavramı => {} kapsama alanı

        // Değişkenler (Variables)
        // Kodun akışında değer tutan isimli veriler.

        System.out.println(10);
        int X = 15; // Değişken tanımlandı. X ismine bir değer atandı.
        // Tanımlandıktan itibaren değişebilir, erişilebilir.
        System.out.println(X);
        X=20;
        System.out.println(X);

        // Değişken tipleri => int, double, boolean, char, String
        String name = "Ayşe";
        String age = "25";
        boolean isStudent = true;
        char grade = 'A';

        String name2 = "Ayşe";
        System.out.println(name2);
        name2 = "Ahmet";
        System.out.println(name2);
        String name3 = name2.concat("abc"); 
        // String immutable (değiştirilemez) bir yapıya sahiptir. 
        // concat() gibi metotlar yeni bir String oluşturur, mevcut String'i değiştirmez.
        System.out.println(name3);

        System.out.println("***********");

        // Diziler (Arrays)

        String[] names = { "Halit", "Ayşe", "Mehmet" };
        System.out.println(names[0]); // index, 0 dan başlar.

        // Primitive (ilkel) tipler -> int, double,boolean,char
        int a = 0;
        int b = a;
        a = 10;
        System.out.println(a); 
        System.out.println(b); 

        System.out.println("***********");

        // Referans tipler -> String, Array, Object
        int[] c = {0,1,2,3};
        int[] d = c;
        d[3] = 30;
        System.out.println(c[3]); //İki referans da aynı diziye işaret ettiği için c[3] de 30 olur.
        System.out.println(d[3]); 


        System.out.println(a==b);// false, çünkü a ve b farklı değerler tutar. a'nın değeri 10, b'nin değeri 0'dır.
        System.out.println(c==d);// true, çünkü c ve d aynı diziye referans verirler.


        int[] x = {0,1,2,3};
        int[] y = {0,1,2,3};
        System.out.println(y);
        System.out.println(x==y); // false, çünkü x ve y farklı dizilere referans verirler.
        System.out.println(Arrays.equals(x, y));// true, çünkü Arrays.equals() içindeki elemanları karşılaştırır ve aynı olduklarını görür.

        System.out.println("***********");

        String s1 = "Merhaba";
        String s2 = "Merhaba";
        System.out.println(s1==s2); // String Pool 
        // (Aynı metinlerin bir havuzda toplanıp performans için birebir olanları aynı referansa ata.)

        // Yine de daha güvenli bir karşılaştırma için equals() kullanılır.
        System.out.println(s1.equals(s2));

        String s3 = "Turkcell";
        String s4 = s3.intern(); 
        // intern() metodu, s3'ün değerini String Pool'a ekler ve oradaki referansı döndürür.

        System.out.println(s3==s4);// true, çünkü s3 ve s4 aynı String Pool referansını paylaşır.

        String str3 = "Turkcell";
        String str4 = new String("Turkcell"); // instance oluşturur, farklı referans

        System.out.println(str3==str4); // false, farklı referanslar

        System.out.println("Merhaba" + " " + "Dünya!");

        System.out.println("***********");

        System.out.println(10 * 20);
        System.out.println(10 / 3);

        System.out.println(1 == 1);
        System.out.println(1 != 1);
        System.out.println(5 > 10);

        a = a + 5;
        a+=5;
        a++; // a = a + 1;

        System.out.println("***********");

        // Döngüler

        // X işlemini birden fazla kez çalıştırmak.
        // iteration = yineleme
        // değişken, koşul, her iterasyon sonrası işlem
        for(int i=0; i<5; i++) {
            System.out.println(i);
        }

        String[] students = {"Halit", "Ayşe", "Mehmet"};
        for(int i=0; i<students.length; i++) {
            System.out.println(students[i]);    
        }
        for(String z: students) {
            System.out.println(z);
        }

        System.out.println("***********");

        // iterasyon => koşul
        int whileDongusu = 0;
        while(whileDongusu < 5) {
            System.out.println("Sonsuz döngü");
            whileDongusu++;
        }

    }
}// Main classının kapsama alanı (sınır)