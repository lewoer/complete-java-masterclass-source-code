package com.shile;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: ShiLe
 * @Description: 1. Collections.unmodifiableMap 返回一个不会修改的，read-only map view.d
 *                  但是可以通过get() method 修改，所以避免get（）
 *               2. getOrdefault(Object key, V defaultValue)返回与key关联的value，否则返回default。
 *               3. Map.Entry 是一个inner interface，可以很方便的获取key,value值，不需要先得到key的集合，再迭代由key得到value。
 *                  它的方法entrySet()返回一个Set<Map.Entry<K, V>>
 *               4. pritln自动调用toString()方法
 *               5. String.format()返回一个格式化的String.
 *
 * @Date: Created in 15:27 2019/1/3
 */
public class StockList {

    private final Map<String,StockItem> list;

    // 不需要参数
    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // 检查这个item是否有数量,getOrdefault()
            StockItem inStock = list.getOrDefault(item.getName(), item);

            // 如果这里早就有货物了，调整数量quantity
            if (inStock != item) {
                item.adjustStock(inStock.availableQuantity());
            }

            list.put(item.getName(),item);
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);

        if ((inStock != null) && (quantity > 0)) {
            return inStock.finaliseStock(quantity);
        }
        return 0;
//        StockItem inStock = list.getOrDefault(item,null); // means instock contanin item
//
//        if ((inStock != null) && (inStock.availableQuantity() >= quantity) && (quantity > 0)) {
//            inStock.adjustStock(-quantity);
//            return quantity;
//        }
//
//        return 0;
    }

    public int reverseStock(String item, int quatity) {
        StockItem inStock = list.get(item);

        if ((inStock != null) && (quatity > 0)) {
            return  inStock.reserveStock(quatity);
        }
        return 0;
    }

    public int unreverseStock(String item, int quatity) {
        StockItem inStock = list.get(item);

        if ((inStock != null) && (quatity > 0)) {
            return  inStock.unreserveStock(quatity);
        }
        return 0;
    }


    // 获取item
    public StockItem get(String key) {
        return list.get(key);
    }

    // 返回一个只有只读权限的map view，但是可以通过get修改
    public Map<String,StockItem> Items() {

        return Collections.unmodifiableMap(list);
    }

    /*
         String, Double为immutable。map不能被修改，individual entries 也不能修改
    *    所以在collections访问对象需要限制，避免返回任何包含真实对象的collection
    *   */
    public Map<String,Double> priceList() {
        Map<String,Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String,StockItem> item : list.entrySet()) {
            prices.put(item.getKey(),item.getValue().getPrice());
        }

        return Collections.unmodifiableMap(prices);
    }



    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;

        for (Map.Entry<String,StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s = s + stockItem + ". There are " + stockItem.availableQuantity() + " in stock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total value " + totalCost;
    }
}
