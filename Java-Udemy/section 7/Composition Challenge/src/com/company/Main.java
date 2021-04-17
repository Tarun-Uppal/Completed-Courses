package com.company;

public class Main {

    public static void main(String[] args) {
	Bed theBed=new Bed("King Size");
	Table theTable=new Table("4 seater");
    Cubard theCubard=new Cubard("teakwood");
    TV theTV = new TV("Sony 65 inch");

    Room theRoom =new Room(theBed,theTable,theCubard,theTV);

    theRoom.area(10,10);
    theRoom.bedArea(10,20);
    }
}
