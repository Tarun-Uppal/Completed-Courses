package com.company;

public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        FootballPlayer beckham = new FootballPlayer("Beckham");

        Team <FootballPlayer>adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayer());

        Team<BaseballPlayer> baseballTeam =new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);

        Team<FootballPlayer> brokenTeam = new Team<>("This wont work");
        brokenTeam.addPlayer(beckham);

    }

}
