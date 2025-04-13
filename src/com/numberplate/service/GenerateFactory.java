package com.numberplate.service;

public class GenerateFactory {
    public static RandomLetterGenerator createRandomLetterGenerator() {
        return new RandomLetterGenerator();
    }

    public static AgeIdentifierCalculator createAgeIdentifierCalculator() {
        return new AgeIdentifierCalculator();
    }
}
