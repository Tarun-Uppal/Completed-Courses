package com.company;

public class CarBase {
    private int steeringDegeree;
    private int speed;

    public CarBase(int steeringDegeree, int gears, int speed) {
        this.steeringDegeree = steeringDegeree;
        this.speed = speed;
    }

    public int getSteeringDegeree() {
        return steeringDegeree;
    }

    public int getSpeed() {
        return speed;
    }
}
