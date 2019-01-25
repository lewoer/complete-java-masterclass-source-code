package com.shile;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 16:22 2019/1/1
 */
public class Location implements Serializable {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;
    private long serialVersionUID = 1L;

    public Location(int locationID, String description,Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null ) {
            /*为了避免引发 NullPointerException*/
            this.exits = new LinkedHashMap<>(exits);
        } else {
            this.exits = new LinkedHashMap<>();
        }
        this.exits.put("Q",0);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<>(exits);  //返回一个副本，用于remove，add
    }

    protected void addExit(String direction, int location) {
        exits.put(direction,location);
    }
}
