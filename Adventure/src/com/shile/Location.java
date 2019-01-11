package com.shile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ShiLe
 * @Description: immutable class作为map的key必要因素
 *               1. 所有的field为private final
 *               2. no "setter" methods
 *               3. 子类不能重写方法
 *                  - 简单版：declare class as final
 *                  - 复杂版： make constructor private and construct instances in factory methods
 *               4.如果instance field包含mutable对象的引用，不允许这些对象改变
 *                      - 不要提供方法来修改mutable object
 *                      - 不要对mutable object共享reference。不要在外界存储reference，不要把mutable object传递到构造器。
 *                        如果需要，存储reference到copy中。及时创建internal mutable object 的copy，避免在方法中返回original。
 * @Date: Created in 16:22 2019/1/1
 */
public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description,Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null ) {
            /*为了避免引发 NullPointerException*/
            this.exits = new HashMap<String, Integer>(exits);
        } else {
            this.exits = new HashMap<String, Integer>();
        }
        this.exits.put("Q",0);
    }

//    public void addExit(String direction, int locationID) {
//        exits.put(direction, locationID);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);  //返回一个副本，用于remove，add
    }
}
