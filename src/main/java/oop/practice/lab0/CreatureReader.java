package oop.practice.lab0;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatureReader {

    public List<Creature> readCreatures(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File(filePath);
        JsonNode data = mapper.readTree(inputFile).get("data");

        List<Creature> creatures = new ArrayList<>();

        for (JsonNode entry : data) {
            int id = entry.hasNonNull("id") ? entry.get("id").asInt() : -1;
            String name = entry.hasNonNull("name") ? entry.get("name").asText() : null;
            String species = entry.hasNonNull("species") ? entry.get("species").asText() : null;
            String universe = entry.hasNonNull("planet") ? entry.get("planet").asText() : null;
            int age = entry.hasNonNull("age") ? entry.get("age").asInt() : 0;
            boolean isHumanoid = entry.hasNonNull("isHumanoid") && entry.get("isHumanoid").asBoolean();
            List<String> traits = new ArrayList<>();

            if (entry.hasNonNull("traits")) {
                for (JsonNode trait : entry.get("traits")) {
                    traits.add(trait.asText());
                }
            }

            Creature creature = new Creature(id, name, species, universe, age, isHumanoid, traits);
            creatures.add(creature);
        }

        return creatures;
    }
}
