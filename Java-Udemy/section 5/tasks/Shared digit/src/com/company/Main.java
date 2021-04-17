package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(14,21));
    }

    public static boolean hasSharedDigit(int first, int second) {
        if ((first >= 10) && (first <= 99) && (second >= 10) && (second <= 99)) {
            if (first / 10 == second / 10) {
                return true;
            }
            if (first / 100 == second / 10) {
                return true;
            }
            if (first / 10 == second / 100) {
                return true;
            }
            if (first / 100 == second / 100) {
                return true;
            }


        }
        return false;
    }
}
