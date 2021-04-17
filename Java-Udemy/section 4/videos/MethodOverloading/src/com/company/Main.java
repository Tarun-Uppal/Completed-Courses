package com.company;

public class Main {

    public static void main(String[] args) {
        String playername;
        int score;
        calculateScore("Tarun", 500);
        calculateScore(100);
        calculateScore();
    }
    public static int calculateScore (String playername,int score){
        System.out.println("player " + playername + " scored " + score + " points");
        return score * 1000;

    }
    public static int calculateScore (int score) {
        System.out.println("player unnnamed player scored " + score + " points");
        return score * 1000;
    }
    public static int calculateScore () {
        System.out.println("player unnnamed player scored unkown points");
        return 0;

    }

    }

