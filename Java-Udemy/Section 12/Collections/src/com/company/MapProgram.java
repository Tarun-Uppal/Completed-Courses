package com.company;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String,String> languages = new HashMap<>();

//        if(languages.containsKey("Java")){
//            System.out.println("java is already in map");
//        }else {
//            languages.put("Java"," This course is about Java");
//            System.out.println("Java added successfully");
//        }

        languages.put("Java"," A compiled high level ,object-orientated ,platform independant language");
        languages.put("Python","An interpreted high level programing language with dynamic semantics");
        languages.put("Algol","An algorithmic language");
        languages.put("BASIC","Beginners All Purpose Symbolic Instruction Code");
        languages.put("Lisp","Therein lies madness");

//        System.out.println(languages.get("Java"));

//        System.out.println(languages.get("Java"));

        System.out.println("=================================================");

//        languages.remove("Lisp");

//        if(languages.remove("Algol" , "An algorithmic language")){
//            System.out.println("Algol removed");
//        }else {
//            System.out.println("Algol not removed , key/value pair not found");
//        }

        if (languages.replace("Lisp" ,"Therein lies madness", "a functional programming language")){
            System.out.println("Lisp replaced");
        }else {
            System.out.println("Lisp was not replaced");
        }
//        System.out.println(languages.replace("Scala"," this will not be replaced"));

        for(String key : languages.keySet()){
            System.out.println(key + " " + languages.get(key));
        }



    }
}
