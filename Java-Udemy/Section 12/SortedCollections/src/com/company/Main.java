package com.company;

public class Main {

    public static StockList stockList = new StockList();
    public static String[] name = new String[1000];
    public static int[] quantityName =new int[1000];
    private static int quantityNoOf;



    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread",0.86,100);
        stockList.addStock(temp);

        temp = new StockItem("Cake",1.10,7);
        stockList.addStock(temp);

        temp = new StockItem("Car",12.50,2);
        stockList.addStock(temp);

        temp = new StockItem("Chair",62.0,10);
        stockList.addStock(temp);

        temp = new StockItem("Cup",0.50,200);
        stockList.addStock(temp);

        temp = new StockItem("Door",72.95,4);
        stockList.addStock(temp);

        temp = new StockItem("Juice",2.50,36);
        stockList.addStock(temp);

        temp = new StockItem("Phone",96.99,35);
        stockList.addStock(temp);

        temp = new StockItem("Towel",2.40,80);
        stockList.addStock(temp);

        temp = new StockItem("Vase",8.76,40);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket basket = new Basket("Vase");
        sellItem(basket,"Vase",5);
        removeItem(basket,"Vase",3);

        System.out.println(stockList);

        confirmOrder(basket);

        System.out.println(stockList);


    }
    public static int sellItem (Basket basket,String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem== null){
            System.out.println("We don't sell " + item);
            return 0;
        }
            basket.addToBasket(stockItem,quantity);
        name[quantityNoOf] = item;
        quantityName[quantityNoOf] = quantity;
        quantity++;

        return quantity;
    }



    public static int removeItem (Basket basket,String item, int quantity){
        StockItem stockItem = stockList.get(item);
                basket.removeFromBasket(stockItem, quantity);

        int nameInArray = findNameArray(name,item);
        int priceToQuantity = quantityName[nameInArray];
        quantityName[nameInArray] = priceToQuantity - quantity;

        return quantity;
    }

    public static int confirmOrder(Basket basket){
        for (int i = 0;i<name.length;i++){
            stockList.sellStock(name[i], quantityName[i]);
        }
        basket.confirmOrder();
        return 1;
    }

    public static int findNameArray(String[] array,String name){
        for (int i =0;i<array.length;i++){
            if (array[i] == name){
                return i;
            }
        }
        return 0;
    }
}
