package com.company;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellite;
    private final BodyTypes bodyType;
    private final Key key;

    public enum BodyTypes{
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }


    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes type) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellite = new HashSet<>();
        this.bodyType = type;
        this.key =new Key(name,bodyType);
    }

    public String getName() {
        return name;
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    public boolean addSatellite(HeavenlyBody moon){
        return this.satellite.add(moon);
    }

    public Set<HeavenlyBody> getSatellite(){
        return new HashSet<>(this.satellite);
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) obj;
            if(this.name.equals(theObject.getName())){
                return this.key.equals(theObject.getKey());
            }
        }
            return false;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    public static Key makeKey(String name,BodyTypes bodyType){
        return new Key(name,bodyType);
    }

    @Override
    public String toString() {
        return this.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    public static final class Key{
        private String name;
        private BodyTypes bodyType;

        private Key (String name,BodyTypes bodyTypes){
            this.name = name;
            this.bodyType = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key)obj;
            if(this.name.equals(key.getName())){
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }
    }
}
