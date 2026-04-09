package com.turkcell;


// Implement diyorsan imzaları birebir aynı şekilde yazmalısın, yoksa hata verir.
public class PgCarRepository implements CarRepository{
    public void add(Car car) 
    {
        System.out.println("Araba nesnesi postgresql'e eklendi");
    }
}
