package com.shile;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("光辉影院",8,12);

        if (theatre.reserveSeat("D12")) {
            System.out.println("please pay D12");
        } else {
            System.out.println("Seat is already reserved");
        }
        if (theatre.reserveSeat("B13")) {
            System.out.println("please pay B13");
        } else {
            System.out.println("Seat is already reserved");
        }


        // shallow copy
        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00",13.00));
        priceSeats.add(theatre.new Seat("A00",13.00));
        Collections.sort(priceSeats,Theatre.PRICE_ORDER);
        printList(priceSeats);



    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("=================================================================");

    }





}
