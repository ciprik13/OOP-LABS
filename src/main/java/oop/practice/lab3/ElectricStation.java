package oop.practice.lab3;

public class ElectricStation implements Refuelable {
    private int electricCarsServed = 0;
    private static int electricConsumption = 0;

    @Override
    public void refuel(int carId, int consumption) {
        System.out.println("Refueling electric car " + carId);
        electricCarsServed++;
        electricConsumption += consumption;
    }

    public int getElectricCarsServed() {
        return electricCarsServed;
    }

    public static int getElectricConsumption(){
        return electricConsumption;
    }

}
