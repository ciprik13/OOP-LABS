package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    File inputFile = new File("src/main/resources/test-input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    System.out.println("Original JSON data from file:");
    System.out.println(data.toPrettyString());

    // list to store Creature objects - container for internal class
    List<Creature> creatures = new ArrayList<>();

    for (JsonNode entry : data) {
      String name = entry.has("name") ? entry.get("name").asText() : "Unknown";
      String species = entry.has("species") ? entry.get("species").asText() : "Unknown";
      String universe = entry.has("planet") ? entry.get("planet").asText() : "Unknown";
      int age = entry.has("age") ? entry.get("age").asInt() : 0;
      boolean isHumanoid = entry.has("isHumanoid") ? entry.get("isHumanoid").asBoolean() : false;
      List<String> traits = new ArrayList<>();

      if (entry.has("traits")) {
        for (JsonNode trait : entry.get("traits")) {
          traits.add(trait.asText());
        }
      }

      //  Creature instance and add to list - map JSON data to class
      Creature creature = new Creature(name, species, universe, age, isHumanoid, traits);
      creatures.add(creature);
    }

    System.out.println("\nCreatures with even IDs:");
    for (int i = 0; i < data.size(); i++) {
      if (i % 2 == 0) {
        System.out.println(data.get(i).toPrettyString());
      }
    }

    System.out.println("\nCreatures with odd IDs:");
    for (int i = 0; i < data.size(); i++) {
      if (i % 2 != 0) {
        System.out.println(data.get(i).toPrettyString());
      }
    }
  }
}

record Universe(
        String name,
        List<JsonNode> individuals
) { }