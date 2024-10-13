package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Read {
    public static void main(String[] args) throws IOException {
        // Initialize the ObjectMapper from Jackson library
        ObjectMapper mapper = new ObjectMapper();

        // File location - adjust the path as per your setup
        File inputFile = new File("src/main/resources/test-input.json");

        // Read and parse the file into a JsonNode object
        JsonNode rootNode = mapper.readTree(inputFile);

        // Print the entire JSON content
        System.out.println("Complete JSON data:");
        System.out.println(rootNode.toPrettyString());

        // Access and print individual JSON objects (if present in a 'data' array)
        JsonNode dataArray = rootNode.get("data");

        if (dataArray != null) {
            System.out.println("\nIndividual JSON Objects:");
            for (JsonNode dataEntry : dataArray) {
                System.out.println(dataEntry.toPrettyString());
            }
        } else {
            System.out.println("No 'data' array found in the JSON.");
        }
    }
}
