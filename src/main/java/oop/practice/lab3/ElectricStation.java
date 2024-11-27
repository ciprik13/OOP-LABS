package oop.practice.lab3;

public class ElectricStation implements Refuelable {
    private int electricCarsServed = 0;

    @Override
    public void refuel(String carId) {
        System.out.println("Refueling electric car " + carId);
        electricCarsServed++;
    }

    public int getElectricCarsServed() {
        return electricCarsServed;
    }
}
