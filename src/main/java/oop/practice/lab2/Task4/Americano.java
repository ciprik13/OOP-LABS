package oop.practice.lab2.Task4;

public class Americano extends Coffee {
    protected int mlOfWater;
    protected final String name = "Americano";

    public Americano(Intensity coffeeintensity, int mlOfWater){
        super(coffeeintensity);
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public void setMlOfWater(int mlOfWater) {
        this.mlOfWater = mlOfWater;
    }

    @Override
    public String getName() {
        return name;
    }

    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(getName() + " water: " + mlOfWater + " ml");
    }

    @Override
    public void make(){
        super.make();
        System.out.println("Adding " + getMlOfWater() + "mg of pumpkin spice");
    }

    public Americano makeAmericano(){
        System.out.println("Making " + getName());
        this.make();
        return this;
    }
}
