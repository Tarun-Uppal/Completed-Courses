package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Theatre {
    private final String theatreName;
    private ArrayList<Seat> seats =new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER =new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()){
                return -1;
            }else if (seat1.getPrice() > seat2.getPrice()){
                return 1;
            }else{
                return 0;
            }
        }
    };

    public Theatre(String theatreName,int numRows,int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows-1);
        for (char row = 'A';row<=lastRow;row++){
            for (int seatNum = 1; seatNum<=seatsPerRow;seatNum++){
                int price = 12;
                if(row<'D' && seatNum >= 4 && seatNum <= 9){
                    price = 14;
                }if(row<'F' || seatNum < 4 || seatNum>9){
                    price= 7;
                }
                Seat seat = new Seat(row + String.format("%02d",seatNum),price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){
       Seat requestedSeat = new Seat(seatNumber,0);
       int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
       if(foundSeat >= 0){
           return seats.get(foundSeat).reserve();
       }else{
           System.out.println("There is no seat " + seatNumber);
           return false;
       }
    }


    public ArrayList<Seat> getSeats(){
        return seats;
    }

    public static class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;
        private int price;

        public Seat(String seatNumber,int price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }else{
                return false;
            }
        }

        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation if seat " + seatNumber + " cancelled");
                return true;
            }else{
                return false;
            }
        }

        public int getPrice() {
            return price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}
