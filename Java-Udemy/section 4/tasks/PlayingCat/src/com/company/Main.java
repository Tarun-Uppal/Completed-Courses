package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(isCatPlaying(true,45));
    }
        public static boolean isCatPlaying(boolean summer,int temprature){
            if ((summer = false) && (temprature >= 25) && (temprature <= 35)){
                return true;
            }
            if ((summer = true) && (temprature >= 25) && (temprature <= 45)){
                return true;
            }
            else{
                return false;
            }
        }

}
