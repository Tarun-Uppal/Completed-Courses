package com.company;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String,StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem stockItem){
        if(stockItem != null){
            StockItem inStock = list.getOrDefault(stockItem.getName(),stockItem);
            if (inStock != stockItem){
                stockItem.addStock(inStock.quantityInStock());
            }
            list.put(stockItem.getName(),stockItem);
            return stockItem.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item,int quantity){
        StockItem inStock = list.getOrDefault(item,null);
        if (inStock != null && inStock.quantityInStock() >= quantity && quantity > 0){
            inStock.sellStock(quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    @Override
    public String toString() {
       String s = "\n Stock list \n";
       double totalCost = 0.0;
       for(Map.Entry<String,StockItem> item : list.entrySet()){
           StockItem stockItem = item.getValue();

           double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

           s = s +  stockItem + ". There are "  + stockItem.quantityInStock() +" in stock. Value of items : ";
           s = s + String.format("%.2f",itemValue) + "\n";
           totalCost += itemValue;
       }
       return s + "Total stock value "+ totalCost;
    }
}
