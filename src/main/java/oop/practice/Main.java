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

    // Initialize universes for creature classification
    Universe starWars = new Universe("StarWars", new ArrayList<>());
    Universe hitchhikers = new Universe("Hitchhikers", new ArrayList<>());
    Universe marvel = new Universe("Marvel", new ArrayList<>());
    Universe rings = new Universe("Lord of the Rings", new ArrayList<>());

    // List to store creatures
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

      Creature creature = new Creature(name, species, universe, age, isHumanoid, traits);
      creatures.add(creature);

      String classification = classifyCreature(creature, starWars, hitchhikers, marvel, rings, mapper);
      System.out.println("Creature with id:" + creatures.size() + " belongs to universe: " + classification);
    }
  }

  private static String classifyCreature(Creature creature, Universe starWars, Universe hitchhikers, Universe marvel, Universe rings, ObjectMapper mapper) {
    String classification = null;

    // Star Wars classification
    if (!creature.isHumanoid() && "Kashyyyk".equalsIgnoreCase(creature.getUniverse())) {
      starWars.individuals().add(mapper.valueToTree(creature));
      classification = "StarWars";
    } else if (!creature.isHumanoid() && "Endor".equalsIgnoreCase(creature.getUniverse())) {
      starWars.individuals().add(mapper.valueToTree(creature));
      classification = "StarWars";
    } else if (creature.getTraits().contains("HAIRY") && creature.getTraits().contains("TALL") && creature.getAge() <= 400) {
      starWars.individuals().add(mapper.valueToTree(creature));
      classification = "StarWars";
    } else if (creature.getTraits().contains("SHORT") && creature.getTraits().contains("HAIRY") && creature.getAge() <= 60) {
      starWars.individuals().add(mapper.valueToTree(creature));
      classification = "StarWars";
    }

    // Lord of the Rings classification
    else if ("Earth".equalsIgnoreCase(creature.getUniverse())) {
      if (creature.isHumanoid() && creature.getTraits().contains("BLONDE") && creature.getTraits().contains("POINTY_EARS")) {
        rings.individuals().add(mapper.valueToTree(creature));
        classification = "Lord of the Rings";
      } else if (creature.isHumanoid() && creature.getTraits().contains("SHORT") && creature.getTraits().contains("BULKY")) {
        rings.individuals().add(mapper.valueToTree(creature));
        classification = "Lord of the Rings";
      } else if (creature.isHumanoid() && creature.getAge() > 200) {
        rings.individuals().add(mapper.valueToTree(creature));
        classification = "Lord of the Rings";
      } else if (creature.getTraits().contains("BLONDE") && creature.getTraits().contains("TALL")) {
        rings.individuals().add(mapper.valueToTree(creature));
        classification = "Lord of the Rings";
      } else {
        rings.individuals().add(mapper.valueToTree(creature));
        classification = "Lord of the Rings";
      }
    }

    // Marvel classification
    else if (creature.isHumanoid() && "Asgard".equalsIgnoreCase(creature.getUniverse())) {
      marvel.individuals().add(mapper.valueToTree(creature));
      classification = "Marvel";
    } else if (creature.getTraits().contains("BLONDE") && creature.getTraits().contains("TALL") && creature.getAge() <= 5000) {
      marvel.individuals().add(mapper.valueToTree(creature));
      classification = "Marvel";
    }

    // Hitchhikers classification
    else if (creature.isHumanoid() && "Betelgeuse".equalsIgnoreCase(creature.getUniverse())) {
      hitchhikers.individuals().add(mapper.valueToTree(creature));
      classification = "Hitchhikers";
    } else if (creature.getTraits().contains("EXTRA_ARMS") || creature.getTraits().contains("EXTRA_HEAD")) {
      hitchhikers.individuals().add(mapper.valueToTree(creature));
      classification = "Hitchhikers";
    } else if (!creature.isHumanoid() && (creature.getTraits().contains("GREEN") || creature.getTraits().contains("BULKY"))) {
      hitchhikers.individuals().add(mapper.valueToTree(creature));
      classification = "Hitchhikers";
    }

    // Additional conditions for Lord of the Rings
    else if (creature.isHumanoid() && creature.getTraits().contains("BULKY")) {
      rings.individuals().add(mapper.valueToTree(creature));
      classification = "Lord of the Rings";
    } else if (creature.isHumanoid() && creature.getAge() > 1000) {
      rings.individuals().add(mapper.valueToTree(creature));
      classification = "Lord of the Rings";
    }

    return classification;
  }
}

record Universe(
        String name,
        List<JsonNode> individuals
) { }
