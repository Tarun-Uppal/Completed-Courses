package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League <T extends Teams> implements Comparable<League<T>>{
    List<T> teamName = new ArrayList<T>();
    private String name;
    int won = 0;
    int tied = 0;

    public League(String name) {
        this.name = name;
    }

    public boolean addTeam(T player){
        if(teamName.contains(player)){
            System.out.println(player.getName() + " is already on the league");
            return false;
        }else{
            teamName.add(player);
            System.out.println(player.getName() + " is added to " + this.name + " league");
            return true;
        }
    }

    public void printTeams(){
        Collections.sort(teamName);
      for (int i = 0;i<teamName.size();i++){
          System.out.println(teamName.get(i));
      }
    }

    public int ranking(){
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(League<T> team) {
        if(this.ranking() > team.ranking()){
            return -1;
        }if(this.ranking() < team.ranking()){
            return 1;
        }else {
            return 0;
        }
    }


}
