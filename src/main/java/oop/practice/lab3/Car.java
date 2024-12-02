package oop.practice.lab3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private int id;
    private String type;
    private String passengerType;
    private boolean isDining;
    private int consumption;

    @JsonCreator
    public Car(
            @JsonProperty("id") int id,
            @JsonProperty("type") String type,
            @JsonProperty("passengers") String passengerType,
            @JsonProperty("isDining") boolean isDining,
            @JsonProperty("consumption") int consumption) {
        this.id = id;
        this.type = type;
        this.passengerType = passengerType;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    public int getId() {
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
