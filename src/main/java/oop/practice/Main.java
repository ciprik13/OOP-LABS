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

    List<Creature> starWars = new ArrayList<>();
    List<Creature> hitchhikers = new ArrayList<>();
    List<Creature> marvel = new ArrayList<>();
    List<Creature> rings = new ArrayList<>();

    // List to store creatures
    List<Creature> creatures = new ArrayList<>();

    for (JsonNode entry : data) {
      // Gather data from each JSON entry
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

      // Classify creature into a universe
      String classification = classifyCreature(creature, starWars, hitchhikers, marvel, rings);
      System.out.println("Creature with id:" + creature.getId() + " belongs to universe: " + classification);
    }

    // Write the universes to JSON files
    View view = new View();
    view.writeToJsonFile("StarWars", starWars, "src/main/resources/output/starwars.json");
    view.writeToJsonFile("Hitchhikers", hitchhikers, "src/main/resources/output/hitchhiker.json");
    view.writeToJsonFile("Marvel", marvel, "src/main/resources/output/marvel.json");
    view.writeToJsonFile("Lord of the Rings", rings, "src/main/resources/output/rings.json");

    System.out.println("Output written to JSON files.");
  }

  private static String classifyCreature(Creature creature, List<Creature> starWars, List<Creature> hitchhikers, List<Creature> marvel, List<Creature> rings) {
    String classification = null;

    // Star Wars classification
    if (!creature.isHumanoid() && "Kashyyyk".equalsIgnoreCase(creature.getUniverse())) {
      starWars.add(creature);
      classification = "StarWars";
    } else if (!creature.isHumanoid() && "Endor".equalsIgnoreCase(creature.getUniverse())) {
      starWars.add(creature);
      classification = "StarWars";
    } else if (creature.getTraits().contains("HAIRY") && creature.getTraits().contains("TALL") && creature.getAge() <= 400) {
      starWars.add(creature);
      classification = "StarWars";
    } else if (creature.getTraits().contains("SHORT") && creature.getTraits().contains("HAIRY") && creature.getAge() <= 60) {
      starWars.add(creature);
      classification = "StarWars";
    }

    // Lord of the Rings classification
    else if ("Earth".equalsIgnoreCase(creature.getUniverse())) {
      if (creature.isHumanoid() && creature.getTraits().contains("BLONDE") && creature.getTraits().contains("POINTY_EARS")) {
        rings.add(creature);
        classification = "Lord of the Rings";
      } else if (creature.isHumanoid() && creature.getTraits().contains("SHORT") && creature.getTraits().contains("BULKY")) {
        rings.add(creature);
        classification = "Lord of the Rings";
      } else if (creature.isHumanoid() && creature.getAge() > 200) {
        rings.add(creature);
        classification = "Lord of the Rings";
      } else if (creature.getTraits().contains("BLONDE") && creature.getTraits().contains("TALL")) {
        rings.add(creature);
        classification = "Lord of the Rings";
      } else {
        rings.add(creature);
        classification = "Lord of the Rings";
      }
    }

    // Marvel classification
    else if (creature.isHumanoid() && "Asgard".equalsIgnoreCase(creature.getUniverse())) {
      marvel.add(creature);
      classification = "Marvel";
    } else if (creature.getTraits().contains("BLONDE") && creature.getTraits().contains("TALL") && creature.getAge() <= 5000) {
      marvel.add(creature);
      classification = "Marvel";
    }

    // Hitchhikers classification
    else if (creature.isHumanoid() && "Betelgeuse".equalsIgnoreCase(creature.getUniverse())) {
      hitchhikers.add(creature);
      classification = "Hitchhikers";
    } else if (creature.getTraits().contains("EXTRA_ARMS") || creature.getTraits().contains("EXTRA_HEAD")) {
      hitchhikers.add(creature);
      classification = "Hitchhikers";
    } else if (!creature.isHumanoid() && (creature.getTraits().contains("GREEN") || creature.getTraits().contains("BULKY"))) {
      hitchhikers.add(creature);
      classification = "Hitchhikers";
    }

    // Additional conditions for Lord of the Rings
    else if (creature.isHumanoid() && creature.getTraits().contains("BULKY")) {
      rings.add(creature);
      classification = "Lord of the Rings";
    } else if (creature.isHumanoid() && creature.getAge() > 1000) {
      rings.add(creature);
      classification = "Lord of the Rings";
    }

    return classification;
  }
}
