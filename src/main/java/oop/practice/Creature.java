package oop.practice;

public class Creature {
    private String name;
    private String species;
    private String universe;

    public Creature(String name, String species, String universe) {
        this.name = name;
        this.species = species;
        this.universe = universe;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public void printCreatureInfo() {
        System.out.println("Name: " + name + ", Species: " + species + ", Universe: " + universe);
    }
}
