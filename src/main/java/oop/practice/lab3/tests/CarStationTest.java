package oop.practice.lab3.tests;

import oop.practice.lab3.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.Queue;

public class CarStationTest {

    @Test
    public void testCarStationServing() {
        Dineable diningService = new PeopleDinner();
        Refuelable refuelingService = new ElectricStation();
        Queue<Car> queue = new LinkedList<>();
        CarStation station = new CarStation(diningService, refuelingService, queue);

        station.addCar(new Car("1", "ELECTRIC", "PEOPLE", true, 40));
        station.addCar(new Car("2", "ELECTRIC", "ROBOTS", false, 50));
        station.addCar(new Car("3", "ELECTRIC", "PEOPLE", true, 30));
        station.addCar(new Car("4", "ELECTRIC", "ROBOTS", false, 40));

        station.serveCars();

        assertTrue(station.isQueueEmpty());
        assertEquals(2, station.getPeopleCounter());
        assertEquals(2, station.getRobotCounter());
        assertEquals(2, ((PeopleDinner) diningService).getPeopleServed());
    }

    @Test
    public void testCarStationEmptyQueue() {
        Dineable diningService = new RobotDinner();
        Refuelable refuelingService = new GasStation();
        Queue<Car> queue = new LinkedList<>();
        CarStation station = new CarStation(diningService, refuelingService, queue);

        assertTrue(station.isQueueEmpty());

        station.serveCars();

        assertEquals(0, station.getPeopleCounter());
        assertEquals(0, station.getRobotCounter());
    }
}
