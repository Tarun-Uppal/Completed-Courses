package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList =new GroceryList();


    public static void main(String[] args) {

        boolean quit =false;
        int choice = 0;
        printInstructions();
        while (!quit){
            System.out.print("Enter your choices: ");
            choice = scanner.nextInt();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    proscessArrayList();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println
                ("\t 0 - To print choice options.");
        System.out.println
                ("\t 1 - To print the list of grocery items.");
        System.out.println
                ("\t 2 - To add an item to the list.");
        System.out.println
                ("\t 3 - To modify an item to the list");
        System.out.println
                ("\t 4 - To remove an item in the list");
        System.out.println
                ("\t 5 - To search for an item in the list");
        System.out.println
                ("\t 6 - To process the array");
        System.out.println
                ("\t 7 - To quit the application");
    }

    public static void addItem(){
        System.out.print("Please enter the grocery item: ");
        String itemToAdd=scanner.next();
        scanner.nextLine();
        groceryList.addGroceryItem(itemToAdd);
    }

    public static void modifyItem(){
        System.out.print("Enter current item name: ");
        String itemNo = scanner.next();
        scanner.nextLine();
        System.out.print("Enter new item: ");
        String newItem = scanner.next();
        scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo,newItem);
    }

    public static void removeItem() {
        System.out.print("Item to search for: ");
        String itemNo = scanner.next();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    public static void searchForItem(){
        System.out.print("Item to search for: ");
        String searchItem = scanner.next();
        scanner.nextLine();
        if(groceryList.onfile(searchItem)){
            System.out.println("Found " + searchItem + " in the grocery list");
        }
        else{
            System.out.println(searchItem + " not in the grocery list");
        }
    }
    public static void proscessArrayList() {
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());


        ArrayList<String> nextArray = new ArrayList<String>
                (groceryList.getGroceryList());

        String[] myArrary = new String
                [groceryList.getGroceryList().size()];
        myArrary = groceryList.getGroceryList().toArray(myArrary);
        }
}
