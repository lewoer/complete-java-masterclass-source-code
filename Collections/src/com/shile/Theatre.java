package com.shile;

import java.util.*;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 21:08 2018/12/31
 */
public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();  // Seat inner class

    // 匿名内建类实施了Comparator
    static final Comparator<Seat> PRICE_ORDER;

    // static initialization block
    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }

    public Theatre(String theatreName,int numRows, int seatPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1); // A在ubicode表中为65

        for (char row = 'A'; row<=lastRow; row++) {
            for (int seatNum=1; seatNum<=seatPerRow; seatNum++) {
                double price = 12.00;
                if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00;
                } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d",seatNum),price);  // %02d格式化为至少2位十进制
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        // 使用java内置计算搜索次数
//        int low = 0;
//        int high = seats.size() -1;
//
//        while (low<=high) {
//            System.out.print("."); // 计算搜索次数
//            int mid = (low + high) / 2;
//            Seat midVal = seats.get(mid);
//            int cmp = midVal.getSeatNumber().compareTo(seatNumber);
//
//            if (cmp <0) {
//                low = mid + 1;
//            } else if (cmp > 0) {
//                high = mid -1;
//            } else {
//                return seats.get(mid).reserve();
//            }
//        }
//        System.out.println("there is no seat" + seatNumber);
//        return false;
        Seat requestedSeat = new Seat(seatNumber,0);
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("there is no seat" +  seatNumber);
            return false;
        }
//        for (Seat seat : seats) {
//            System.out.print(".");
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if (requestedSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//
//        return requestedSeat.reserve();

    }
    // for test

    public Collection<Seat> getSeats() {
        return seats;

    }

    public class Seat implements Comparable<Seat>{
        //inner class
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            // reserve预定 reverse反转
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }

        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of the seat " + seatNumber + " canceled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }
}
