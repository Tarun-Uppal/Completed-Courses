package com.company;

public class Main {

    public static void main(String[] args) {

        for(int noOfTables=15;noOfTables==15;noOfTables--){
            int t1=1;
            int t2=1;
            int t3=0;

            for (int i=0;t1!=16;t1++){
                t2=1;
                System.out.println("");
                System.out.println(t1 + " times table");
                System.out.println("");
                do {
                    t3 = t1 * t2;
                    System.out.println(t1 + " * " + t2 + " = " + t3);
                    t2++;
                } while (t2 != 16);
            }
        }
    }
}
