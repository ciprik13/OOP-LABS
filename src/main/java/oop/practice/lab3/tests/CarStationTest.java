package oop.practice.lab3.tests;

import oop.practice.lab3.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarStationTest {

    @Test
    public void testCarStationServing() {
        PeopleDinner diningService = new PeopleDinner();
        ElectricStation refuelingService = new ElectricStation();
        Queue<Car> queue = new ArrayQueue<>();

        CarStation station = new CarStation(diningService, refuelingService, queue);

        station.addCar(new Car("1", true));
        station.addCar(new Car("2", false));

        station.serveCars();

        assertTrue(station.isQueueEmpty());
        assertEquals(1, diningService.getPeopleServed());
        assertEquals(2, refuelingService.getElectricCarsServed());
    }

    @Test
    public void testCarStationEmptyQueue() {
        Dineable diningService = new RobotDinner();
        Refuelable refuelingService = new GasStation();
        Queue<Car> queue = new LinkedQueue<>();

        CarStation station = new CarStation(diningService, refuelingService, queue);

        assertTrue(station.isQueueEmpty());
        station.serveCars();
    }
}
