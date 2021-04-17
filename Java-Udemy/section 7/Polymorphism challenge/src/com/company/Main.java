package com.company;

class Car {

    private int cylinders;
    private String name;
    private int speed;
    private int motorRpm;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.speed = 0;
        this.motorRpm=0;
    }

    public void setMotorRpm(int motorRpm) {
        this.motorRpm = motorRpm;
    }

    public int getMotorRpm() {
        return motorRpm;
    }
}
class Evo9 extends Car{

    public Evo9() {
        super(6, "Evo9");
    }

    @Override
    public void setMotorRpm(int motorRpm) {
        super.setMotorRpm(motorRpm);
    }

    public int startEngine() {
        this.setMotorRpm(1000);
        return getMotorRpm();
    }
}class Evo10 extends Car{

    public Evo10() {
        super(8, "Evo10");
    }

    @Override
    public void setMotorRpm(int motorRpm) {
        super.setMotorRpm(motorRpm);
    }

    public int startEngine() {
        this.setMotorRpm(10);
        return getMotorRpm();
    }


}
class Evo8 extends Car{

    public Evo8() {
        super(6, "Evo8");
    }

    @Override
    public void setMotorRpm(int motorRpm) {
        super.setMotorRpm(motorRpm);
    }

    public int startEngine() {
       this.setMotorRpm(100);
       return getMotorRpm();
    }
}


public class Main {

    public static void main(String[] args) {
        System.out.println(new Evo8());
    }
}
