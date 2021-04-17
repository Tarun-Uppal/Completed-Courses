package com.company;

public class Printer {

    private int tonerLevel;
    private int noOfPages;
    private boolean isDuplex;
    private int x;
    private int y;

    public Printer(int tonerLevel, int noOfPages, boolean isDuplex,int x,int y) {
        if(tonerLevel<100&&tonerLevel>0) {
            this.tonerLevel = tonerLevel;
        }
        this.noOfPages = noOfPages;
        this.isDuplex = isDuplex;
        this.x=x;
        this.y=y;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public boolean isDuplex() {
        return isDuplex;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int pointToPrint(int x,int y){
        return x*y;
    }

    public int toner(){
        int minusTonerLevel=noOfPages;
        if(isDuplex=true){
            minusTonerLevel=noOfPages*2;
            System.out.println(pages());
            return tonerLevel-=minusTonerLevel;
        }
        System.out.println(pages());
        minusTonerLevel=noOfPages*1;
        return tonerLevel-=minusTonerLevel;
    }

    public String pages(){
        noOfPages--;
        return "Page "+ noOfPages + " printed at point "+pointToPrint(x,y);
    }
}
