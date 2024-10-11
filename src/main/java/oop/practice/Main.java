package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {

//    Creature creature1 = new Creature("Zaphod Beeblebrox", "Betelgeusian", "Hitchhikers");
//    Creature creature2 = new Creature("Luke Skywalker", "Human", "Star Wars");
//    Creature creature3 = new Creature("Frodo Baggins", "Hobbit", "Lord of the Rings");
//
//    creature1.printCreatureInfo();
//    creature2.printCreatureInfo();
//    creature3.printCreatureInfo();
//
//    creature1.setUniverse("Hitchhikers");
//    creature1.printCreatureInfo();

    Read.main(null);

    ObjectMapper mapper = new ObjectMapper();
    File inputFile = new File("src/main/resources/test-input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());


    System.out.println("Classify the creatures manually to their Universe");
    Scanner scanner = new Scanner(System.in);

    for (JsonNode entry : data) {
      String entryAsString = entry.toString();
      System.out.println(entryAsString);
      String userInput = scanner.nextLine();
      switch (userInput) {
        case "1":
          starWars.individuals().add(entry);
          break;
        case "2":
          hitchhikers.individuals().add(entry);
          break;
        case "3":
          marvel.individuals().add(entry);
          break;
        case "4":
          rings.individuals().add(entry);
          break;
        default:
          System.out.println("Invalid input");
      }
    }

    scanner.close();

    File outputDir = new File("src/main/resources/output");
    if (!outputDir.exists()) {
      outputDir.mkdirs();  // create the directory if it does not exist
    }

    mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
    mapper.writeValue(new File("src/main/resources/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);
    mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);
  }
}

record Universe(
    String name,
    List<JsonNode> individuals
) { }
