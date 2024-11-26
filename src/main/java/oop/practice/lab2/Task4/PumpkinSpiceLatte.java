package oop.practice.lab2.Task4;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;
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

//    public void makePumpkinSpiceLatte(){
//        super.makeCappuccino();
//        System.out.println("Adding " + getMgOfPumpkinSpice() + "mg of pumpkin spice");
//    }

    @Override
    public void make(){
        super.make();
        System.out.println("Adding " + getMgOfPumpkinSpice() + "mg of pumpkin spice");
    }

    public PumpkinSpiceLatte makePumpkinSpiceLatte(){
        System.out.println("Making " + getName());
        this.make();
        return this;
    }
}
