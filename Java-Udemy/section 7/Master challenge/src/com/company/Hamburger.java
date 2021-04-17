package com.company;


public class Hamburger extends Additions{

    private int hamburgerCost;
    private int int1;
    private int int2;
    private int int3;
    private int int4;


    public void hamburger1(){
        int1 = 110;
        System.out.println(hamburger("Standard"));
    }
    public void hamburger2(){
        int1 = 120;
        System.out.println(hamburger("Vegie"));
    }
    public void hamburger3(){
        int1 = 130;
        System.out.println(hamburger("Funcy"));
    }
    public void hamburger4(){
        int1 = 140;
        System.out.println(hamburger("Healthy"));
    }
    public void hamburger5(){
        int1 = 150;
        System.out.println(hamburger("Dulex"));
    }
    public String hamburger(String hamburger){
        int2 = new Additions().breadRollType();
        int3 = new Additions().lettuceTomatoCarrotMayonise();
        int4 = new Additions().meat();
        int total = int1 + int2 + int3 + int4;
        return "your total is " + total + " for a " + hamburger + " hamburger";
    }

}
