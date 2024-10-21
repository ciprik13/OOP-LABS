package oop.practice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class View {
// todo make this static
    private ObjectMapper mapper;

    public View() {
        this.mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public void writeToJsonFile(String universeName, List<Creature> creatures, String filePath) {
        try {
            // Create a wrapper object for the universe
            UniverseWrapper wrapper = new UniverseWrapper(universeName, creatures);

            // Write the data to JSON file with pretty print
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), wrapper);

            System.out.println("Successfully written to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filePath);
            e.printStackTrace();
        }
    }

    // Wrapper class to match the expected output structure
    private static class UniverseWrapper {
        public String name;
        public List<Creature> individuals;

        public UniverseWrapper(String name, List<Creature> individuals) {
            this.name = name;
            this.individuals = individuals;
        }
    }
}
