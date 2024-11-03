package oop.practice.lab2.Task2;

public class SyrupCappuccino extends Cappuccino {
    protected SyrupType syrup;
    protected final String name = "SyrupCappuccino";

    public SyrupCappuccino(Intensity coffeeintensity, int mlOfMilk, SyrupType syrup){
        super(coffeeintensity, mlOfMilk );
        this.syrup = syrup;
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    public void setSyrup(SyrupType syrup) {
        this.syrup = syrup;
    }

    @Override
    public String getName() {
        return name;
    }

    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(getName() + " syrup: " + syrup + " syrup");
    }
}
