package com.company;

public class Car extends CarBase{

    private int Gears;
    private boolean isManuel;

    public Car(int degeree, int steeringDegeree, int speed) {
        super(steeringDegeree, 0 ,speed);
    }

    public String steeringDegree(int steeringDegree){

        if(steeringDegree>0&&steeringDegree<180){

            if(steeringDegree>0&&steeringDegree<90){
                return " left";
            }
            if(steeringDegree>90&&steeringDegree<180){
                return "right";
            }
            if(steeringDegree==90){
                return "Straight";
            }
        }
            return "1000";
    }
    public String changingGears(int speed){
        if(speed <= 0){
            return "Reverse";
        }
        if(speed <= 300) {
            if (speed < 60) {
                return "1";
            }
            if (speed < 120) {
                return "2";
            }
            if (speed < 180) {
                return "3";
            }

            if (speed > 240) {
                return "4";
            }

            if (speed > 300) {
                return "5";
            }
        }
        return "0";
    }
}
