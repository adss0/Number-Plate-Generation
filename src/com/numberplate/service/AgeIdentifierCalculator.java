package com.numberplate.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AgeIdentifierCalculator {
    public String generate(String date) {
        LocalDate localDate = parseDate(date);
        int year = localDate.getYear() % 100;
        int month = localDate.getMonthValue();

        // Adjust the year based on month
        if (month < 3 || month > 8) {
            year += 50;
        }

        return String.format("%02d", year);
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
