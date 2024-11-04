package oop.practice.lab2.Task4;

public class Coffee {

    public enum Intensity{
        LIGHT, NORMAL, STRONG
    }

    public enum SyrupType {
        MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN
    }

    protected Intensity coffeeIntensity;
    protected final String name = "Coffee";

    public Coffee(Intensity coffeeIntensity){
        this.coffeeIntensity = coffeeIntensity;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public void setCoffeeIntensity(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public String getName() {
        return name;
    }

    public void printCoffeeDetails() {
        System.out.println("Coffee Intensity: " + coffeeIntensity);
    }

    public void makeCoffee(){
        printCoffeeDetails();
        System.out.println("Making "+ getName());
        System.out.println("Set intensity to "+ getCoffeeIntensity());
    }
}