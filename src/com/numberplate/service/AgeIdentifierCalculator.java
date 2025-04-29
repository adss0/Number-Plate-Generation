package com.numberplate.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AgeIdentifierCalculator {
    public String generate(String date) {
        LocalDate localDate = parseDate(date);
        int year = localDate.getYear();
        int month = localDate.getMonthValue();

        if (month < 3) {
            year -= 1;  // Months Jan-Feb belong to the previous year
        }

        int ageIdentifier = year % 100;

        if (month < 3 || month > 8) {
            ageIdentifier += 50;
        }

        return String.format("%02d", ageIdentifier);
    }
    private LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(date, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format: " + date, e);
        }
    }
}
