package com.company;

import java.util.ArrayList;

public class Contacts {

    private ArrayList<String> Contacts = new ArrayList<>();
    private ArrayList<String> Numbers = new ArrayList<>();


    public void modifyContactName(String contactName,String newContactName){
        int Contactposition = findContact(contactName);
        int Contactposition1 = findContact(newContactName);
        if((Contactposition < 0)&&(Contactposition1 < 0)){
            Contacts.set(Contactposition,newContactName);
            int p2=Contactposition+1;
            System.out.println("Contact number " + p2 + " modified to " +
                    newContactName + " with name of " + contactName);
        }else {
            System.out.println("Contact number with contact name of " + contactName + " not found or");
            System.out.print("Contact already exists with " + newContactName + " exists,");
        }
    }

    public void modifyContactNumber(String contactName,String newContactNumber){
        int Contactposition = findContact(contactName);
        int Numberposition = findNumber(newContactNumber);
        if((Contactposition < 0)&&(Numberposition < 0)){
            Numbers.set(Contactposition,newContactNumber);
            System.out.println("Contact name " + contactName + " modified to " +
                    newContactNumber + ".");
        }else {
            System.out.println("Contact number with contact name of " + contactName + " not found or");
            System.out.print("number with contact number of " + newContactNumber + " exists.");
        }
    }

    public void addContact(String contactName,String ContactNumber){
        int Contactposition = findContact(contactName);
        int Numberposition = findNumber(ContactNumber);
        if((Contactposition < 0)&&(Numberposition < 0)){
            Numbers.add(ContactNumber);
            Contacts.add(contactName);
            System.out.println("Contact " + contactName + " added with " +
                    ContactNumber + " number.");
        }else {
            System.out.println("Contact " + contactName + " already exists or");
            System.out.print("Contact already exists with " + ContactNumber + " exists.");
        }
    }
    public void removeContact(String contactName){
        int position = findContact(contactName);
        if(position >= 0){
            String contactNumber = Numbers.get(position);
            Numbers.remove(contactNumber);
            Contacts.remove(contactName);
            System.out.println("Contact name " + contactName + " with " +
                    contactNumber + " removed.");
        }else {
            System.out.println("Contact " + contactName + " not found.");
        }

    }
    public void printContact(){
        System.out.println("You have " +
                Contacts.size() +
                " people in your contact list");

        for (int i=0;i<Contacts.size();i++){
            System.out.println((i+1) + ". "
                    + Contacts.get(i)+ " - " + Numbers.get(i));
        }
    }

    public int findContact(String contactName) {
        return Contacts.indexOf(contactName);
    }

    public int findNumber(String contactName) {
        return Numbers.indexOf(contactName);
    }
    public void toLookForContact(String contactName) {
        int position = findContact(contactName);
        if(position >= 0){
            System.out.println("Contact " + contactName + " found.");
        }else{
            System.out.println("Contact " + contactName + " not found.");
        }
    }

    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println
                ("\t 0 - To quit.");
        System.out.println
                ("\t 1 - To print all the contacts.");
        System.out.println
                ("\t 2 - To add a contact.");
        System.out.println
                ("\t 3 - To rename a contact");
        System.out.println
                ("\t 4 - To change a contact number");
        System.out.println
                ("\t 5 - To remove a contact");
        System.out.println
                ("\t 6 - To find a contact");
    }
}
