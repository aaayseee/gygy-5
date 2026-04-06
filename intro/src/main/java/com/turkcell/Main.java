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



        // Karar Blokları

        // Belirli 1+ kapsamdaki kod bloklarını belirli koşullara göre ateşlemek.
        // Karar bloğu = minimum 1 maksimum n adet karara göre farklı kodlar çalıştırabilir.
        // Koşul: true-false

        // Her koşul bloğu yalnızca maksimum 1 scope çalıştırır.
        // Kodlar yukarıdan aşağıya çalıştırılır.
        int age2 = 18;

        if (age2 >= 18) {
            System.out.println("Yetki verildi");
        }
        else if (age2 == 18) {
            System.out.println("Yaşınız tam 18, ay kontrolü yapılıyor.");
        }
        else {
            System.out.println("Yetki verilmedi");
        }

        String username = "halit";
        if(username.equals("tamer"))
        {
            System.out.println("Tamer hoş geldin..");
        } // Karar blokları illaki bir scope çalıştırma zorunluluğu barındırmaz.


         /// ....... öğrenci notu hesaplama
        String result1 = calculateGrade(85); // konsola yaz
        String result2 = calculateGrade(70, "Ayşe"); // db'e yaz gibi farklı işlemler yapılabilir.
        String result3 = calculateGrade(60); // email at..
        String result4 = calculateGrade(50, "Nurgül");
        String result5 = calculateGrade(30, "Tamer");

        System.out.println(result1); // result1 konsola yazar ve diğer resultlar farklı işlemler yapabilir.

        // result2 db'e yaz
        // result3 mail at..



        double toplam1 = sum(10.5, 20.3);
        System.out.println(toplam1);

        double toplam2 = sum(1,2,3,4,5,6,7);
        System.out.println(toplam2);

    }


    // Methodlar => belirli bir işi yapan kod bloklarıdır. Tekrar tekrar kullanılabilirler.
    // erişim-belirteci - static veya boş - dönüş tipi (void => boş) - method ismi - (parametreler) - {}
    // bir parametre tanımlıysa, null bile olsa göndermek zorundasın.
    public static String calculateGrade(int grade, String name) // required parameter
    {
        if(grade >= 85)
        {
            String result = name + " Notunuz: A";
            return result; //dönüş tipi String olduğu için, String bir değer döndürmelidir bu yüzden return kullanılır.
            //System.out.println(name + " Notunuz: A"); // return kullanıldığında, methodun geri kalan kodları çalışmaz.
        }
        else if(grade >= 70)
        {
            return name + " Notunuz: B";
        }
        else if(grade >= 50)
        {
            return name + " Notunuz: C";
        }
        else
        {
            return name + " Notunuz: F";
        }
    }

    // Name gönderilmezse, "Öğrenci" olarak varsayılan değer alsın.
    // Method Overloading => Aynı isimde, farklı parametre sayısına sahip methodlar oluşturma.
    public static String calculateGrade(int grade)
    {
        return calculateGrade(grade, "Öğrenci");
    }

    //Sayıları toplayan sum methodu
     public static double sum(double a, double b){ //Burda sadece iki sayı toplayabiliriz
        return a + b;
    }

    public static double sum(double... numbers) { // varargs sayesinde istediğimiz kadar sayı toplayabiliriz, numbers bir dizi olarak çalışır.
        double total = 0;
        for(double num: numbers) {
            total += num;
        }
        return total;
    }

}// Main classının kapsama alanı (sınır)


// CTRL + SHIFT + P
// User Settings
// Compact
// Explorer: Compact Folders kapat Bu sayede klasörler tek tek görünecektir.