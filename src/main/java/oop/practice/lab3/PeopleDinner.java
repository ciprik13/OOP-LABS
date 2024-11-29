package oop.practice.lab3;

public class PeopleDinner implements Dineable {
    private int peopleServed = 0;
    private static int totalPeople = 0;

    @Override
    public void serveDinner(int carId) {
        System.out.println("Serving dinner to people in car " + carId);
        peopleServed++;
    }

    public int getPeopleServed() {
        return peopleServed;
    }

    public static void countPeople(){
        totalPeople++;
    }
}

