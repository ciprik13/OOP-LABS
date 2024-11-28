package oop.practice.lab3;

import java.util.HashMap;
import java.util.Map;

public class Semaphore {
    private final CarStation gasPeopleStation;
    private final CarStation gasRobotStation;
    private final CarStation electricPeopleStation;
    private final CarStation electricRobotStation;

    private final Map<String, Integer> carTypeCount = new HashMap<>();
    private final Map<String, Integer> passengerTypeCount = new HashMap<>();
    private int isDiningCount = 0;
    private int isNotDiningCount = 0;

    public Semaphore(CarStation gasPeopleStation, CarStation gasRobotStation, CarStation electricPeopleStation, CarStation electricRobotStation) {
        this.gasPeopleStation = gasPeopleStation;
        this.gasRobotStation = gasRobotStation;
        this.electricPeopleStation = electricPeopleStation;
        this.electricRobotStation = electricRobotStation;

        carTypeCount.put("GAS", 0);
        carTypeCount.put("ELECTRIC", 0);
        passengerTypeCount.put("PEOPLE", 0);
        passengerTypeCount.put("ROBOTS", 0);
    }

    public void routeCar(Car car){
        String type = car.getType();
        String passengerType = car.getPassengerType();

        if (car.getType() == "GAS" && car.getPassengerType() == "PEOPLE"){
            gasPeopleStation.addCar(car);
            carTypeCount.put("GAS", carTypeCount.get("GAS") + 1);
            passengerTypeCount.put("PEOPLE", passengerTypeCount.get("PEOPLE")+ 1);
        }
        if (car.getType() == "GAS" && car.getPassengerType() == "ROBOTS"){
            gasPeopleStation.addCar(car);
            carTypeCount.put("GAS", carTypeCount.get("GAS") + 1);
            passengerTypeCount.put("ROBOTS", passengerTypeCount.get("ROBOTS") + 1);
        }
        if (car.getType() == "ELECTRIC" && car.getPassengerType() == "PEOPLE"){
            gasPeopleStation.addCar(car);
            carTypeCount.put("ELECTRIC", carTypeCount.get("ELECTRIC") + 1);
            passengerTypeCount.put("PEOPLE", passengerTypeCount.get("PEOPLE")+ 1);
        }
        if (car.getType() == "ELECTRIC" && car.getPassengerType() == "ROBOTS"){
            gasPeopleStation.addCar(car);
            carTypeCount.put("ELECTRIC", carTypeCount.get("ELECTRIC") + 1);
            passengerTypeCount.put("ROBOTS", passengerTypeCount.get("ROBOTS") + 1);
        }

        if (car.isDining()){
            isDiningCount++;
        } else{
            isNotDiningCount++;
        }
    }

    public void serveCar(){
        gasPeopleStation.serveCars();
        gasRobotStation.serveCars();
        electricPeopleStation.serveCars();
        electricRobotStation.serveCars();
    }

    public Map<String, Integer> getStats(){
        Map<String, Integer> stats = new HashMap<>();
        stats.put("ELECTRIC cars served", carTypeCount.getOrDefault("ELECTRIC", 0));
        stats.put("GAS cars served", carTypeCount.getOrDefault("GAS", 0));
        stats.put("PEOPLE are served", passengerTypeCount.getOrDefault("PEOPLE", 0));
        stats.put("ROBOTS are served", passengerTypeCount.getOrDefault("ROBOTS", 0));
        stats.put("Is Dining", isDiningCount);
        stats.put("Is not Dining", isNotDiningCount);
        return stats;

    }
}