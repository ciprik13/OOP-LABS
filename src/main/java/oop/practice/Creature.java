package oop.practice;

import java.util.List;

public class Creature {
    private String name;
    private String species;
    private String universe;
    private int age;
    private boolean isHumanoid;
    private List<String> traits;

    public Creature(String name, String species, String universe, int age, boolean isHumanoid, List<String> traits) {
        this.name = name;
        this.species = species;
        this.universe = universe;
        this.age = age;
        this.isHumanoid = isHumanoid;
        this.traits = traits;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getUniverse() {
        return universe;
    }

    public int getAge() {
        return age;
    }

    public boolean isHumanoid() {
        return isHumanoid;
    }

    public List<String> getTraits() {
        return traits;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public void printCreatureInfo() {
        System.out.println("Name: " + name + ", Species: " + species + ", Universe: " + universe
                + ", Age: " + age + ", Humanoid: " + isHumanoid
                + ", Traits: " + (traits != null ? traits.toString() : "None"));
    }
}
