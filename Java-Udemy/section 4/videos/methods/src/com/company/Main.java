package com.company;

public class Main {

    public static void main(String[] args) {

        int highscore = calculatescore(true, 800, 5, 100);
        System.out.println("your final score is " + highscore);

        int newhighscore = calculatescore(true, 10000, 8, 200);
        System.out.println("your final score is " + newhighscore);


        public static int calculatescore(boolean gameover,int score,int levelcompleted,int bonus){

            if (gameover == true) {
                int finalscore = score + (levelcompleted * bonus);
                finalscore += 2000;
                return finalscore;
            }
            return -1;
        }


    }












