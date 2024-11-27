package oop.practice.lab3;

public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private Queue<Car> queue;

    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    public void addCar(Car car) {
        queue.push(car);
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.pop();

            if (car.isDining()) {
                diningService.serveDinner(car.getId());
            }

            refuelingService.refuel(car.getId());
        }
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }
}

