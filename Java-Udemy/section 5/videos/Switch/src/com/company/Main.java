package com.company;

public class Main {

    public static void main(String[] args) {
	int value = 1;
	if (value == 1){
        System.out.println("Value was 1");
    }
	else if (value == 1){
        System.out.println("Value was 2");
    }
	else{
        System.out.println("was not 1 or 2");
    }
	int SwitchValue = 2;
	switch (SwitchValue){
        case 1 :
            System.out.println("value was 1");
            break;
        case 2 :
            System.out.println("value was 2");
            break;
        case 3:case 4:case 5:
            System.out.println("it was 3 ,4 or 5");
        default:
            System.out.println("value was not 1 or 2");
    }
    String switchValue = "hi";
	switch(switchValue){
        case "hi":
            System.out.println("hi");
            break;
        case "bye":
            System.out.println("bye");
            break;
        case "see you":
            System.out.println("see you");
            break;
        default:
            System.out.println("never see you again");
            break;
    }
    char switchChar = 'A';
	switch(switchChar){
        case 'A':
            System.out.println("Char is A");
            break;
        case 'B':
            System.out.println("Char is B");
            break;
        case 'C':
            System.out.println("Char is C");
            break;
        case 'D':
            System.out.println("Char is D");
            break;
        case 'E':
            System.out.println("Char is E");
            break;
        default:
            System.out.println("not found");
            break;
    }
    String month = "januA ry";
	switch(month.toLowerCase()){
        case "january":
            System.out.println("jan");
            break;
        case "february":
            System.out.println("feb");
            break;
        case "march":
            System.out.println("mar");
            break;
        case "april":
            System.out.println("apr");
            break;
        case "may":
            System.out.println("may");
            break;
        case "june":
            System.out.println("june");
            break;
        case "july":
            System.out.println("jul");
            break;
        case "august":
            System.out.println("aug");
            break;
        case "september":
            System.out.println("sep");
            break;
        case "october":
            System.out.println("oct");
            break;
        case "november":
            System.out.println("nov");
            break;
        case "december":
            System.out.println("dec");
            break;
        default:
            System.out.println("invalid month");

    }


    }
}
