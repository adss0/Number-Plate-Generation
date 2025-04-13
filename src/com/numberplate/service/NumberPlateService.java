package com.numberplate.service;

import com.numberplate.Observer.Observer;
import com.numberplate.Observer.PlateLogger;
import com.numberplate.Observer.PlateObserver;

import com.numberplate.storage.PlateRepository;

import java.util.ArrayList;
import java.util.List;

public class NumberPlateService {
    private final AgeIdentifierCalculator ageIdentifierCalculator;
    private final RandomLetterGenerator randomLetterGenerator;
    private final PlateRepository plateRepository;
    private final GenerateFactory generatorFactory;
    private final Observer observer;

    public NumberPlateService() {
        this.generatorFactory = new GenerateFactory();
        this.randomLetterGenerator = GenerateFactory.createRandomLetterGenerator();
        this.ageIdentifierCalculator = GenerateFactory.createAgeIdentifierCalculator();
        this.plateRepository = new PlateRepository();
        this.observer = new Observer();
    }



    public void generateUniqueNumberPlate(String memoryTag, String dateInput) {
        String age = ageIdentifierCalculator.generate(dateInput);
        String randomLetter;
        String plate;
        do {
            randomLetter = randomLetterGenerator.generate();
            plate = memoryTag + age + " " + randomLetter;
        } while (!plateRepository.isUnique(plate));

        observer.notifyObservers(plate);
        plateRepository.saveToFile(plate);

    }
    
}
