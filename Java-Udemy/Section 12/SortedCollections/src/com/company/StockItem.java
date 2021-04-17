package com.company;

public class StockItem implements Comparable <StockItem>{
    private final String name;
    private double price;
    private int quantityStock = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void sellStock(int quantity){
        int newQuantity = this.quantityStock - quantity;
        if (newQuantity > 0 ){
            this.quantityStock = newQuantity;
        }
    }

    public void addStock(int quantity){
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity > 0 ){
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        String objectName = ((StockItem)obj).getName();

        return this.name.equals(objectName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        if(this == o ){
            return 0;
        }
        if (o != null ){
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": Price : " + this.price ;
    }
}
