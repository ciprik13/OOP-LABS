package oop.practice.lab2.Task1;

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
}
