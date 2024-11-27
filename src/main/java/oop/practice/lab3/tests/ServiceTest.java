package oop.practice.lab3.tests;

import oop.practice.lab3.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    @Test
    public void testDineableImplementations() {
        Dineable peopleDinner = new PeopleDinner();
        Dineable robotDinner = new RobotDinner();

        peopleDinner.serveDinner("1");
        robotDinner.serveDinner("2");

        assertEquals(1, ((PeopleDinner) peopleDinner).getPeopleServed());
        assertEquals(1, ((RobotDinner) robotDinner).getRobotsServed());
    }

    @Test
    public void testRefuelableImplementations() {
        Refuelable electricStation = new ElectricStation();
        Refuelable gasStation = new GasStation();

        electricStation.refuel("3");
        gasStation.refuel("4");

        assertEquals(1, ((ElectricStation) electricStation).getElectricCarsServed());
        assertEquals(1, ((GasStation) gasStation).getGasCarsServed());
    }
}

