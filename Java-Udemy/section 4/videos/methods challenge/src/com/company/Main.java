package com.company;

public class Main {


    public static void main(String[] args) {
        int playerscore ;
        String playername;

        int highscoreposition = calculatehighscoreposition(1500);
        displayhighscoreposition("kia",highscoreposition);

        highscoreposition = calculatehighscoreposition(900);
        displayhighscoreposition("bob",highscoreposition);

        highscoreposition = calculatehighscoreposition(400);
        displayhighscoreposition("jhon",highscoreposition);

        highscoreposition = calculatehighscoreposition(50);
        displayhighscoreposition("tim",highscoreposition);

    }
        public static void displayhighscoreposition (String playername, int playerscore){
            System.out.println(playername + " managed to get into position "
                    + playerscore + " on the high score table");
        }


        public static int calculatehighscoreposition (int playerscore){

            if (playerscore >= 1000) {
                return 1;
            }
            if (playerscore >= 500 ) {
                return 2;
            }
            if (playerscore >= 100 ) {
                return 3;
            }
            else {
                return 4;
            }

        }

}
