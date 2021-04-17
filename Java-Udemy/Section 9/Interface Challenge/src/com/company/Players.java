package com.company;

import java.util.ArrayList;
import java.util.List;

public class Players implements ISaveable{

    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Players(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Player{"+
                "name= " + name + '\''+
                " , hitpoints= " + hitPoints +
                ", strength " + strength +
                ", weapon= " + weapon + '\'' +
                " }";
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
         values.add(0,this.name);
         values.add(1,""+this.hitPoints);
         values.add(2,""+this.strength);
         values.add(3,this.weapon);
         return values;
    }

    @Override
    public void read(List<String> read) {
        if(read != null && read.size() >= 0){
            this.name = read.get(0);
            this.hitPoints = Integer.parseInt(read.get(1));
            this.strength = Integer.parseInt(read.get(2));
            this.weapon = read.get(3);
        }
    }
}
