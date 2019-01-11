package com.shile;

import java.util.ArrayList;
import java.util.List;

public class Monster implements Saveable{
    private String name;
    private int hitPoint;
    private int strength;

    public Monster(String name, int hitPoint, int strength) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {

//        \是转义字符
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoint=" + hitPoint +
                ", strength=" + strength +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0,this.name);
        values.add(1,"" + this.hitPoint);
        values.add(2,"" + this.strength);
        return values;
    }

    @Override
    public void read(List<String> savedValue) {
        if (savedValue != null && savedValue.size() > 0) {
            this.name = savedValue.get(0);
            this.hitPoint = Integer.parseInt(savedValue.get(1));  // String解析为decimal integer
            this.strength = Integer.parseInt(savedValue.get(2));
        }

    }
}
