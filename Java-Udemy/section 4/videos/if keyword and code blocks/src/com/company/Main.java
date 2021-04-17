package com.company;

public class Main {

    public static void main(String[] args) {
	boolean gameover = true;
    int score = 1  800;
    int levelcompleted = 5;
    int bonus =  100;

 //   if (score == 5000){
 //       System.out.println("your score was 5000");
 //   }
 //   if (score == 4000){
 //       System.out.println("your score was 4000");
 //   }else
 //       System.out.println("got here");

        if(gameover == true){
            int finalscore = score + (levelcompleted * bonus);
            System.out.println("your final score was " + finalscore);
        }

        int newscore = 10000;
        int newlevelcompleted = 8;
        int newbonus = 200;

        if(gameover == true){
            int finalscore = newscore + (newlevelcompleted * newbonus);
            System.out.println("your final score was " + finalscore);
        }








  }
}
