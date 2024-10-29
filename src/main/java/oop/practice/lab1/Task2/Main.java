package oop.practice.lab1.Task2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the file path as a command line argument.");
            return;
        }

        String filePath = args[0];

        FileReader fileReader = new FileReader();

        try {
            String content = fileReader.readFileIntoString(filePath);

            TextData textData = new TextData(filePath, content);

            textData.displayData();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
