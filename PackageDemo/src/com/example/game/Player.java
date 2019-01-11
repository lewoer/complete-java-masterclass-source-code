package com.example.game;

import java.util.ArrayList;
import java.util.List;

public class Player implements Saveable{
    private String name;
    private int hitPoint;   // 血量
    private int strength;   // 力量
    private String weapon;

    public Player(String name, int hitPoint, int strength) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.strength = strength;
        this.weapon = "Sword";   // hard code

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoint=" + hitPoint +
                ", Strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0,this.name);
        values.add(1,"" + this.hitPoint);
        values.add(2,"" + this.strength);
        values.add(3,this.weapon);
        return values;
    }

    @Override
    public void read(List<String> savedValue) {
        if (savedValue != null && savedValue.size() > 0) {
            this.name = savedValue.get(0);
            this.hitPoint = Integer.parseInt(savedValue.get(1));  // String解析为decimal integer
            this.strength = Integer.parseInt(savedValue.get(2));
            this.weapon = savedValue.get(3);
        }

    }
}
