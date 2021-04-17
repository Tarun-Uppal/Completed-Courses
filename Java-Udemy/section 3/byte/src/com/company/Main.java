package com.company;

public class Main {

    public static void main(String[] args) {


                int myValue = 10000;

                int myintminvalue = Integer.MIN_VALUE;
                int myintmaxvalue = Integer.MAX_VALUE;
                System.out.println("my min int value" + myintminvalue);
                System.out.println("my max int value" + myintmaxvalue);
                System.out.println("busted max value = " + (myintmaxvalue + 1));
                System.out.println("busted min value = " + (myintminvalue - 1 ));

                int mymaxinttest = 2_147_483_647;

                byte minbytevalue = Byte.MIN_VALUE;
                byte maxbytevalue = Byte.MAX_VALUE;
        System.out.println("byte minimum value " + minbytevalue);
        System.out.println("byte maximum value " + maxbytevalue);

                short minshortvalue = Short.MIN_VALUE;
                short maxshortvalue = Short.MAX_VALUE;
        System.out.println("short minimum value " + minshortvalue);
        System.out.println("short maximum value " + maxshortvalue);

        int mytotal = ( myintminvalue / 2 );
        byte mybytetotal =  (byte) ( minbytevalue / 2 );
        short myshorttotal = (short) ( minshortvalue / 2 );

        System.out.println("int value divided by 2 " + mytotal);
        System.out.println("byte value divided by 2 " + mybytetotal);
        System.out.println("short value divided by 2 " + myshorttotal);
    }
}
