package oop.practice.lab3;

import java.util.Queue;

public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private Queue<Car> queue;
    private int peopleCounter = 0;
    private int robotCounter = 0;

    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    public void addCar(Car car) {
        queue.add(car);
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.poll();

            // Serve dinner if necessary
            if (car.isDining()) {
                diningService.serveDinner(car.getId());
            }

            // Refuel the car
            refuelingService.refuel(car.getId());

            // Update counters based on passenger type
            if (car.getPassengerType().equals("PEOPLE")) {
                peopleCounter++;
            } else if (car.getPassengerType().equals("ROBOTS")) {
                robotCounter++;
            }
        }
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    public int getPeopleCounter() {
        return peopleCounter;
    }

    public int getRobotCounter() {
        return robotCounter;
    }
}
