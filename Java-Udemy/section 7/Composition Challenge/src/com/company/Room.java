package com.company;

public class Room {

    Bed theBed;
    Table theTable;
    Cubard theCubard;
    TV theTV;

    public Room(Bed theBed, Table theTable, Cubard theCubard, TV theTV) {
        this.theBed = theBed;
        this.theTable = theTable;
        this.theCubard = theCubard;
        this.theTV = theTV;
    }

    public int area(int x,int y){
        return x * y;
    }
public int bedArea(int x,int y){
        return area(x,y);
}

    public Bed getTheBed() {
        return theBed;
    }

    public Table getTheTable() {
        return theTable;
    }

    public Cubard getTheCubard() {
        return theCubard;
    }

    public TV getTheTV() {
        return theTV;
    }
}
