package com.company;

import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item){
        groceryList.add(item);
    }

    public void printGroceryList(){
        System.out.println("You have " +
                groceryList.size() +
                " items in your grocery list");

        for (int i=0;i<groceryList.size();i++){
            System.out.println((i+1) + ". "
                    + groceryList.get(i));
        }
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void modifyGroceryItem(String currentItem,
                                  String newItem){
        int position = findItem(currentItem);
        if(position >= 0){
            modifyGroceryItem(position,newItem);
        }

    }

    private void modifyGroceryItem(int position ,String newItem){
        groceryList.set(position,newItem);
        System.out.println("Grocery item " + (position+1)
                + " has been modified.");
    }
    public void removeGroceryItem(String item){
        int position = groceryList.indexOf(item);
        if(position >= 0){
            removeGroceryItem(position);
        }
    }
    private void removeGroceryItem(int position){
       groceryList.remove(position);
    }

    private int findItem(String searchItem){
        return groceryList.indexOf(searchItem);

    }
    public boolean onfile(String searchItem){
        int position = findItem(searchItem);
        if(position>=0){
            return true;
        }
        return false;
    }
}
