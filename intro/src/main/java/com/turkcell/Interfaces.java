package com.turkcell;

public class Interfaces {
    public static void main(String[] args) {
        CarRepository carRepository = new MsCarRepository(); // Sol taraf => Bana CarRepository kurallarına uyan somut bir class ver.

        carRepository.add(new Car(true,"BMW"));
        carRepository.add(new Car(true,"Mercedes"));
        carRepository.add(new Car(false,"Ford"));
    }

}
