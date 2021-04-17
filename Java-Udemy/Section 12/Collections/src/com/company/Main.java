package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int seatsPerRow = 12;

    public static void main(String[] args) {
//        int seatsPerRow = 12;
	Theatre theatre = new Theatre("Olampyan",8,seatsPerRow);
//
//
//    if(theatre.reserveSeat("A02")){
//        System.out.println("please pay for A02");
//    }else {
//        System.out.println("Seat already reserved");
//    }
//        if(theatre.reserveSeat("B12")){
//            System.out.println("please pay for B12");
//        }else {
//            System.out.println("Seat already reserved");
//        }
////
////        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
////        Collections.reverse(reverseSeats);
////        printList(reverseSeats,seatsPerRow);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());

        priceSeats.add(new Theatre.Seat("B00",13));
        priceSeats.add(new Theatre.Seat("A00",13));
        Collections.sort(priceSeats,Theatre.PRICE_ORDER);
        printList(priceSeats,seatsPerRow);
    }
    public static void printList (List<Theatre.Seat> list,int rows){
        int noOfRows = 0;
       for (Theatre.Seat seat : list){
           System.out.print(seat.getSeatNumber() + " " + seat.getPrice() + " ");
           noOfRows++;
           if(noOfRows==rows){
               noOfRows = 0;
               System.out.println();
           }

       }
        System.out.println("");
        System.out.println("=======================================");
    }
}
