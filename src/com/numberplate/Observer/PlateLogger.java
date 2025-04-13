package com.numberplate.Observer;

public class PlateLogger implements PlateObserver {
    @Override
    public void onPlateGenerated(String plate) {
        System.out.println("New plate generated: " + plate);
    }
}