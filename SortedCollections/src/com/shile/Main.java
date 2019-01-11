package com.shile;

import java.util.Map;

public class Main {
    private static StockList stockList;

    static {
        stockList = new StockList();
    }

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread",0.88,100);
        stockList.addStock(temp);

        temp = new StockItem("cake",1.01,7);
        stockList.addStock(temp);

        temp = new StockItem("car",12.5,2);
        stockList.addStock(temp);

        temp = new StockItem("chair",14,8);
        stockList.addStock(temp);

        temp = new StockItem("cup",2.01,14);
        stockList.addStock(temp);

        temp = new StockItem("cup",5.01,13);
        stockList.addStock(temp);

        temp = new StockItem("door",56,15);
        stockList.addStock(temp);

        temp = new StockItem("computer",200,30);
        stockList.addStock(temp);

        temp = new StockItem("juice",8.08,24);
        stockList.addStock(temp);

        temp = new StockItem("phone",14.91,90);
        stockList.addStock(temp);

        temp = new StockItem("vase",39.01,7);
        stockList.addStock(temp);

        temp = new StockItem("towel",5.01,98);
        stockList.addStock(temp);

        temp = new StockItem("book",3.01,34);
        stockList.addStock(temp);


        System.out.println(stockList);



        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket lewoerBasket = new Basket("lewoer");
        sellItem(lewoerBasket,"car",1);
        System.out.println(lewoerBasket);


        sellItem(lewoerBasket,"car",1);
        System.out.println(lewoerBasket);

        if (sellItem(lewoerBasket,"car",1) != 1) {
            System.out.println("仓库没车了");

        }
        System.out.println(lewoerBasket);

        sellItem(lewoerBasket,"spanner",5);

//        System.out.println(lewoerBasket);

        sellItem(lewoerBasket,"juice",4);
        sellItem(lewoerBasket,"cup",12);
        sellItem(lewoerBasket,"bread",1);
        sellItem(lewoerBasket,"juice",4);
//        System.out.println(lewoerBasket);

//        System.out.println(stockList);


        Basket basket = new Basket("customer");
        sellItem(basket,"cup",100);
        sellItem(basket,"juice",5);
        removeItem(basket,"cup",1);
        System.out.println(basket);

        removeItem(lewoerBasket,"car",1);
        removeItem(lewoerBasket,"cup",9);
        removeItem(lewoerBasket,"car",1);
        System.out.println("car removed: " + removeItem(lewoerBasket,"car", 1)); // should not remove any


        System.out.println(lewoerBasket);

        removeItem(lewoerBasket,"bread",1);
        removeItem(lewoerBasket,"cup",3);
        removeItem(lewoerBasket,"juice",1);
        removeItem(lewoerBasket,"cup",3);
        System.out.println(lewoerBasket);



        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

        /*即使map是unmodifiableMap，但是里面的对对象还是可以修改的。以后设计系统需要对stockList应该不要get() method*/
        stockList.Items().get("car").adjustStock(2000);
        stockList.get("car").adjustStock(-1000);
        System.out.println(stockList);
        checkOut(lewoerBasket);
        System.out.println(lewoerBasket);





//        for (Map.Entry<String,Double> price : stockList.priceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue() );
//        }

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from the stocklist
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (stockList.reverseStock(item,quantity) != 0) {
            return  basket.addToBasket(stockItem,quantity);
        }

        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // retrieve the item from the stocklist
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return  stockList.unreverseStock(item,quantity);
        }

        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }

}
