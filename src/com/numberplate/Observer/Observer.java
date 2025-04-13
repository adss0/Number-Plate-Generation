package com.numberplate.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    private List<PlateObserver> observers = new ArrayList<>();

    public Observer(){
        addObserver(new PlateLogger());
    }
    public void addObserver(PlateObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PlateObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String plate) {
        for (PlateObserver observer : observers) {
            observer.onPlateGenerated(plate);
        }
    }

}
