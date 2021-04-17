package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(getDurationString(100, 45));
        System.out.println(getDurationString(3945));
    }

    private static String getDurationString(int minutes, int seconds) {
        if ((minutes <= 0) || (seconds <= 0) || (seconds >= 59)) {
            return "invalid value";
            }
        int hours = minutes / 60;
        minutes = minutes % 60;

        String hourString = hours + "h";
        if (hours < 10) {
            hourString = "0" + hourString;
        }
        String minutesString = minutes + "m";
        if (minutes < 10) {
            minutesString = "0" + minutesString;
        }
        String secondsString = seconds + "s";
        if (seconds < 10) {
            secondsString = "0" + secondsString;

            System.out.println(hourString + " " + minutesString + " " + secondsString + " ");

        }
        return hourString + " " + minutesString + " " + secondsString + " ";
    }


    private static String getDurationString(int seconds) {
        if (seconds > 0) {
            return "invalid value";

        }
        int minutes = seconds / 60;
        int remainingseconds = seconds % 60;
        return getDurationString(minutes,seconds);
    }
}
