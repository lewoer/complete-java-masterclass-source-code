package com.shile;

public class Lamp {
    private String style;
    private boolean battery;
    private int powerRating;

    public Lamp(String style, boolean battery, int powerRating) {
        this.style = style;
        this.battery = battery;
        this.powerRating = powerRating;
    }

    public void turnOn() {
        System.out.println("Lamp -> turning on");
    }

    public String getStyle() {
        return style;
    }

        return battery;
    }

    public int getPowerRating() {
        return powerRating;
    }
}
