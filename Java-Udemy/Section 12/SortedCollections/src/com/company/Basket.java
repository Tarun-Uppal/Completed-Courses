package com.company;

import java.util.*;

public class Basket {
    private final String name;
    private final Map<StockItem,Integer>list;
    private StockItem firstStockItem;
    private int stockItemCount;

    public Basket(String name) {
        this.name = name;
        list = new TreeMap<>();
    }

    public int addToBasket(StockItem item,int quantity){
        if(item != null && quantity > 0){
            int stockItemQuantity = item.quantityInStock();
            if(stockItemQuantity > quantity) {
                int inBasket = list.getOrDefault(item, 0);
                list.put(item, inBasket + quantity);
                this.stockItemCount ++;
                if (stockItemCount == 1) {
                    firstStockItem = item;
                }
            }else{
                System.out.println("Quantity more than stock");
            }
        }
        return 0;
    }

    public int removeFromBasket(StockItem item,int quantity){
        if(item != null && quantity > 0){
            int stockItemQuantity = item.quantityInStock();
            if(stockItemQuantity > quantity) {
                int inBasket = list.getOrDefault(item,0);
                int newQuantity = inBasket - quantity;
                if (newQuantity == 0){
                    list.remove(item);
                }else {
                    list.put(item, inBasket - quantity);
                    System.out.println(item + " removed");
                }
            }else{
                System.out.println("Quantity more than stock");
            }
        }
        return 0;
    }

    public int confirmOrder() {
        if (list.size() == 0) {
            System.out.println("There is nothing in your basket");
            return 0;
        } else {

            int inBasket = list.getOrDefault(firstStockItem,0);
            if (inBasket == 0){
                System.out.println("There is nothing in your cart");
            }else{
                System.out.println("Order successful");
                System.out.print("Your order is ");
                    System.out.print(list);
                list.clear();
                stockItemCount =0;
                return 1;
            }
        }
        return 0;
        }

    @Override
    public String toString() {
        String s ;
        if (list.size() == 1){
            s ="\n Shopping Basket " + name + " contains " + list.size() + " item\n";
        }else {
            s = "\n Shopping Basket " + name + " contains " + list.size() + " items\n";
        }
        double totalCost = 0.0;
        for (Map.Entry<StockItem ,Integer> item : list.entrySet()){
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }


}
