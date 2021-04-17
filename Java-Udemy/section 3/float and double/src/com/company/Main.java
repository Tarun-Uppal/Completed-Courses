package com.company;

public class Main {

    public static void main(String[] args) {

        float myminfloatvalue = Float.MIN_VALUE;
        float mymaxfloatvalue = Float.MAX_VALUE;
        System.out.println("float min value " + myminfloatvalue);
        System.out.println("float max value " + mymaxfloatvalue);

        double mymindoublevalue = Double.MIN_VALUE;
        double mymaxdoublevalue = Double.MAX_VALUE;
        System.out.println("double min value " + mymindoublevalue);
        System.out.println("double max value " + mymaxdoublevalue);

        int myintvalue =5 / 3;
        float myfloatvalue = 5f / 3f;
        double mydoublevalue = 5d /3d;
        int mytotal = (int) (myintvalue + myfloatvalue);
        System.out.println(mytotal);
        System.out.println("my int value " + myintvalue);
        System.out.println("my float value " + myfloatvalue);
        System.out.println("my double value " + mydoublevalue);







    }
}
