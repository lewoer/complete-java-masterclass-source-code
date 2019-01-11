package com.shile;

import java.util.ArrayList;

public class GearBox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int curentGear;
    private boolean clutchIsIn;

    public GearBox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        Gear neutral = new Gear(0,0.0);
        this.gears.add(neutral);

        for (int i=0; i< maxGears; i++) {
            addGear(i,i*5.3);
        }
    }


    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }

    // 添加档位
    public void addGear(int number, double ratio) {
        if ((number > 0) && (number <= maxGears)) {
            this.gears.add(new Gear(number, ratio));
        }
    }

    // 换挡
    public void changeGear(int newGear) {
        if ((newGear > 0) && (newGear < this.gears.size()) && (this.clutchIsIn)) {
            this.curentGear = newGear;
            System.out.println("Gear " + newGear + " is selected.");
        } else {
            System.out.println("Grind 卡住了");
            this.curentGear = 0;
        }
    }

    public double wheelSpeed(int rev) {
        if (clutchIsIn) {
            System.out.println("scream!!!");
            return 0.0;
        }
        return rev * gears.get(curentGear).getRatio();   // 发送机转速 * 转速比
    }

    private class Gear {
        // inner class都是private,使用private可以很好的进行封装，外界类不能轻易访问。
        private int gearNumber;
        private double ratio;  // 转速比

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int rev) {
            // rev 发动机转速
            return rev * (this.ratio);
        }
    }

}
