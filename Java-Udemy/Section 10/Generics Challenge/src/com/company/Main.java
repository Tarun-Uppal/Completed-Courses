package com.company;

public class Main {

    public static void main(String[] args) {
        Football man = new Football("Manchester United");
        League league = new League("fifa");
        league.addTeam(man);
        league.printTeams();
    }
}
