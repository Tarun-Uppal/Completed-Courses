package com.company;

public class Car {
    private int doors;
    private int wheels;
    private String model;
    private String colour;
    private String engine;

    public void setModel(String model){
        String validModel = model.toLowerCase();
        if((validModel.equals("carrera"))||(validModel.equals("commodore"))){
            this.model=model;
        }
        else{
            this.model="Unkown";
        }
    }
    public String getModel(){
        return this.model;
    }


}

