package com.company;

public class Main {

    public static void main(String[] args) {
        double v1 = 20.00d;
        double v2 = 80.00d;
        double myvaluetotal = (v1 + v2) * 100d;
        System.out.println(myvaluetotal);
        double theremainder =myvaluetotal % 40.00d;
        System.out.println(theremainder);

        boolean v5 = (theremainder == 0) ? true : false;
        
        if (!v5) {
            System.out.println("got some remainder ");
        }


    }

}
