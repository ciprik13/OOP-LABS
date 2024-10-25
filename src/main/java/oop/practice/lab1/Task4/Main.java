package oop.practice.lab1.Task4;

import oop.practice.lab1.Task2.FileReader;
import oop.practice.lab1.Task2.TextData;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide one or more file paths as command line arguments.");
            return;
        }

        FileReader fileReader = new FileReader();

        for (String filePath : args) {
            try {
                String content = fileReader.readFileIntoString(filePath);
                TextData textData = new TextData(filePath, content);

                System.out.println("=== Data for file: " + filePath + " ===");
                textData.displayData();
                System.out.println();

            } catch (IOException e) {
                System.out.println("Error reading file " + filePath + ": " + e.getMessage());
            }
        }
    }
}
