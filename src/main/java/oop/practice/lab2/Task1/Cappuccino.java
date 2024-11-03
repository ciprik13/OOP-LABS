package oop.practice.lab2.Task1;

public class Cappuccino extends Coffee {
    protected int mlOfMilk;
    protected final String name = "Cappuccino";

    public Cappuccino(Intensity coffeeintensity, int mlOfMilk){
    super(coffeeintensity);
    this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    public String getName() {
        return name;
    }
}