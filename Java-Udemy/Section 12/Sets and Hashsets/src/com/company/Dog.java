package com.company;

public class Dog{
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object object) {
        if(this == object){
            return true;
        }

        if(object instanceof Dog){
            String objName = ((Dog) object).getName();
            return this.name.equals(objName);
        }
        return false;
    }
}
