package oop.practice.lab0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {

    // Create instance of CreatureReader to read creatures
    CreatureReader reader = new CreatureReader();
    List<Creature> creatures = reader.readCreatures("src/main/resources/input.json");

    List<Creature> starWars = new ArrayList<>();
    List<Creature> hitchhikers = new ArrayList<>();
    List<Creature> marvel = new ArrayList<>();
    List<Creature> rings = new ArrayList<>();

    // Create instance of CreatureClassification
    CreatureClassification classifier = new CreatureClassification();

    for (Creature creature : creatures) {
      // Classify the creatures and print classification
      String classification = classifier.classifyCreature(creature, starWars, hitchhikers, marvel, rings);
      System.out.println("Creature with id: " + creature.getId() + " belongs to universe: " + classification);
    }

    // Write the universes to JSON files
    View view = new View();
    view.writeToJsonFile("StarWars", starWars, "src/main/resources/output/starwars.json");
    view.writeToJsonFile("Hitchhikers", hitchhikers, "src/main/resources/output/hitchhiker.json");
    view.writeToJsonFile("Marvel", marvel, "src/main/resources/output/marvel.json");
    view.writeToJsonFile("Lord of the Rings", rings, "src/main/resources/output/rings.json");

    System.out.println("Output written to JSON files.");
  }
}
