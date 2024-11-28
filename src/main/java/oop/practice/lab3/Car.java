package oop.practice.lab3;

public class Car {
    private String id;
    private boolean isDining;
    private String type;
    private String passengerType;
    private int consumption;

    public Car(String id, String type, String passengerType, boolean isDining, int consumption) {
        this.id = id;
        this.type = type;
        this.passengerType = passengerType;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    public String getId() {
        return id;
    }

    public boolean isDining() {
        return isDining;
    }

    public String getType() {
        return type;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public int getConsumption() {
        return consumption;
    }
}
