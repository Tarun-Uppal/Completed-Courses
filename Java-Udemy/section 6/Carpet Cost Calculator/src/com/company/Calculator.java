package com.company;

public class Calculator {
   private Floor floor;
   private Carpet carpet;

    public Calculator(Floor floor, Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    public double getTotalCost(){
        double floor2=floor.getArea();
        double carpet2=carpet.getCost();
        return floor2*carpet2;

    }
}
