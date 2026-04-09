package com.turkcell;


//Araç kısmına giren tüm sınıfların ortak özelliklerini ve davranışlarını tanımlayacağımız sınıf
public class Vehicle { // superclass, parent class, base class
    private String brand;
    private String model;
    private int year;
    private Double pricePerDay;

      public void setPricePerDay(Double pricePerDay) {
        // this => sınıfın kendisi
        if(pricePerDay < 0)
        {
            System.out.println("Fiyat negatif olamaz. 0'a eşitleniyor.."); //set işleminin amacı değişkeni kontrol edebilmek, bu sayede hatalı veri girişi engellenebilir.
            pricePerDay = 0.0;
        }
        this.pricePerDay = pricePerDay;
    }
    public Double getPricePerDay() {
        return this.pricePerDay;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

}
