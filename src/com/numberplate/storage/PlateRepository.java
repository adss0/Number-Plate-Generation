package com.numberplate.storage;
import java.io.*;

public class PlateRepository {

    private static final String FILE_PATH = "generated_plates.txt";

    // Checks if the plate is unique
    public boolean isUnique(String plate) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(plate)) {
                    return false; // Plate found, return false (not unique)
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading plates from file: " + e.getMessage());
            return true;
        }
        return true;
    }

    public void saveToFile(String plate) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(plate);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Failed to save plate: " + e.getMessage());
        }
    }

}

