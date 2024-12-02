package oop.practice.lab3;

public class GasStation implements Refuelable {
    private int gasCarsServed = 0;
    private static int gasConsumption = 0;

    @Override
    public void refuel(int carId, int consumption) {
        System.out.println("Refueling gas car " + carId);
        gasCarsServed++;
        gasConsumption += consumption;
    }

    public int getGasCarsServed() {
        return gasCarsServed;
    }

    public static int getGasConsumption(){
        return gasConsumption;
    }
}
