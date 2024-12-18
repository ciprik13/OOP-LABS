package oop.practice.lab2.Task3;

public class PumpkinSpiceLatte extends Cappuccino {
    protected int mgOfPumpkinSpice;
    protected final String name = "PumpkinSpiceLatte";

    public PumpkinSpiceLatte(Intensity coffeeintensity,int mlOfMilk, int mgOfPumpkinSpice){
        super(coffeeintensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    public void setMgOfPumpkinSpice(int mgOfPumpkinSpice) {
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    @Override
    public String getName() {
        return name;
    }

    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(getName() + " pumpkin spice: " + mgOfPumpkinSpice + " mg");
    }

    public void makePumpkinSpiceLatte(){
        super.makeCappuccino();
        System.out.println("Adding " + getMgOfPumpkinSpice() + "mg of pumpkin spice");
    }
}
