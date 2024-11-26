package oop.practice.lab2.Task3;

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

    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(getName() + " milk: " + mlOfMilk + " ml");
    }

    public void makeCappuccino(){
        super.makeCoffee();
        System.out.println("Adding " + getMlOfMilk() + " ml of milk");
    }
}