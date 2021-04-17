package com.company;

public class Main {

    public static void main(String[] args) {

    }

    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        }
        int numberOfRows=number;
        int numberOfColumns=number;

            for (int currentColumn = numberOfColumns; currentColumn != 0; currentColumn --) {
                System.out.println("");
                for (int currentRow = numberOfRows; currentRow != 0; currentRow --) {

                if ((currentRow == 1) || (currentRow == numberOfRows)) {
                    System.out.print("*");
                }
                if ((currentColumn==1)||(currentColumn==numberOfColumns)) {
                    System.out.print("*");
                }
                if (currentRow == currentColumn) {
                    System.out.print("*");
                }
                if (currentColumn == ((numberOfRows - currentRow) + 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }


            }
        }


    }
}
