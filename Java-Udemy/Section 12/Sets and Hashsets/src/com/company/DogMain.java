package com.company;

public class DogMain {
    public static void main(String[] args) {
        LabradorDog rover = new LabradorDog("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));

    }
}
