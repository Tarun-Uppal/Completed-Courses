package com.company;

import java.util.ArrayList;

public class Teams<T extends Player> implements Comparable<Teams<T>>{
    private String name;
    int played = 0 ;
    int lost = 0;
    int won = 0;
    int tied = 0;
    String message;

    ArrayList<T> members = new ArrayList<>();

    public Teams(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println(player.getName() + " is already on the team");
            return false;
        }else{
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayer(){
        return this.members.size();
    }

    public void matchResult (Teams opponent, int ourScore, int theirScore){
        if(ourScore >theirScore){
            won++;
            message = " beat ";
        }else if(ourScore == theirScore){
            tied++;
            message = " drew with ";
        }else{
            lost++;
            message = " lost to ";
        }
        if(opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null,theirScore,ourScore);
        }
    }

    public int ranking(){
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Teams<T> team) {
        if(this.ranking() > team.ranking()){
            return -1;
        }else if(this.ranking() < team.ranking()){
            return 1;
        }else {
            return 0;
        }
    }
}
