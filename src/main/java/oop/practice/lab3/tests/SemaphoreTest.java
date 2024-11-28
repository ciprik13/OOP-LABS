package oop.practice.lab3.tests;

import oop.practice.lab3.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.Queue;

public class SemaphoreTest {

    @Test
    public void testSemaphoreRoutingAndStats() {
        Dineable gasPeopleDinner = new PeopleDinner();
        Refuelable gasStationService = new GasStation();
        Queue<Car> gasPeopleQueue = new LinkedList<>();
        CarStation gasPeopleStation = new CarStation(gasPeopleDinner, gasStationService, gasPeopleQueue);

        Dineable gasRobotDinner = new RobotDinner();
        Queue<Car> gasRobotQueue = new LinkedList<>();
        CarStation gasRobotStation = new CarStation(gasRobotDinner, gasStationService, gasRobotQueue);

        Dineable electricPeopleDinner = new PeopleDinner();
        Refuelable electricStationService = new ElectricStation();
        Queue<Car> electricPeopleQueue = new LinkedList<>();
        CarStation electricPeopleStation = new CarStation(electricPeopleDinner, electricStationService, electricPeopleQueue);

        Dineable electricRobotDinner = new RobotDinner();
        Queue<Car> electricRobotQueue = new LinkedList<>();
        CarStation electricRobotStation = new CarStation(electricRobotDinner, electricStationService, electricRobotQueue);

        Semaphore semaphore = new Semaphore(
                gasPeopleStation,
                gasRobotStation,
                electricPeopleStation,
                electricRobotStation
        );

        semaphore.routeCar(new Car("1", "GAS", "PEOPLE", true, 40));
        semaphore.routeCar(new Car("2", "GAS", "ROBOTS", false, 50));
        semaphore.routeCar(new Car("3", "ELECTRIC", "PEOPLE", true, 60));
        semaphore.routeCar(new Car("4", "ELECTRIC", "ROBOTS", false, 55));

        semaphore.serveCar();

        Map<String, Integer> stats = semaphore.getStats();
        assertEquals(2, stats.get("GAS cars served"));
        assertEquals(2, stats.get("ELECTRIC cars served"));
        assertEquals(2, stats.get("PEOPLE are served"));
        assertEquals(2, stats.get("ROBOTS are served"));
        assertEquals(2, stats.get("Is Dining"));
        assertEquals(2, stats.get("Is not Dining"));

        assertTrue(gasPeopleStation.isQueueEmpty());
        assertTrue(gasRobotStation.isQueueEmpty());
        assertTrue(electricPeopleStation.isQueueEmpty());
        assertTrue(electricRobotStation.isQueueEmpty());
    }
}
