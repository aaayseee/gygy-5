package com.turkcell;

//Vehicle sınıfının tüm özelliklerini ve davranışlarını miras al
//Üstüne kendi özelliklerini ve davranışlarını ekle

public class Car extends Vehicle {// subclass, child class, derived class
    // Constructor => Yapıcı Metot => Yazmasanız bile bir tane var.
    // Yazarsam => Auto oluşanı override etmiş olursun.

    public Car(boolean hasSunroof, String brand) {
        super(); // Vehicle'ın constructor'ını çağırır.
        this.setHasSunroof(hasSunroof);
        super.setBrand(brand); // -> Super => Vehicle classını (kalıtım aldığım class)
    }
    public Car() { //herhangi bir parametre olmadan da Car nesnesi oluşturabilmek için default constructor ekledik.
    }

    private boolean hasSunroof;
    private String[] specs;

    // Encapsulation => Dışarıdan manipülasyona kapalı.
    public String[] getSpecs() {
        return specs.clone(); //.clone() => referans tiplerde değerlerin kopyalanmasını sağlar, referansın kopyalanmasını değil. Bu sayede dışarıdan gelen değişiklikler içerdeki veriyi etkilemez.
        //Referans tipler için gereklidir, primitive tipler için gerek yoktur çünkü onlar zaten değer tipleridir.
    }
    public void setSpecs(String[] specs) {
        this.specs = specs.clone();
    }
    // Değerlerini al, referansı alma.
    public boolean isHasSunroof() {
        return hasSunroof;
    }
    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }


    /*
    // erişim belirteci: o alana kimlerin erişebileceğini belirleyen sistem
    // public => her yerden erişilebilir
    // private => sadece tanımlanan sınıf içerisinden erişilebilir.
    // protected => sadece tanımlanan sınıf ve o sınıftan (türetilen) sınıflardan erişilebilir.
    // protected => aynı paketteki sınıflardan erişilebilir.

    // Encapsulation
    //
    public double getPrice(){
        // get işlemlerini kontrol eden mekanizma
        return price;
    }
    public void setPrice(double price) {
        // classın kendisi = price
        if(price < 0){
            System.out.println("Fiyat negatif olamaz!");
            return; // metodu sonlandırmak için kullanılır, geri kalan kodların çalışmasını engeller
        }
        this.price = price;*/
    }
}
