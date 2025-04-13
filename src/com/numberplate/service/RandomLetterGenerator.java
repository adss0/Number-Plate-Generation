package com.numberplate.service;

import java.util.Random;

public class RandomLetterGenerator {
    private static final Random RANDOM = new Random();

    public String generate() {
        StringBuilder sb = new StringBuilder(3);

        for (int i = 0; i < 3; i++) {
            char c;
            do {
                c = (char) ('A' + RANDOM.nextInt(26)); // Generate random character A-Z
            } while (c == 'I' || c == 'Q'); // Exclude 'I' and 'Q'
            sb.append(c);
        }
        return sb.toString();
    }
}
