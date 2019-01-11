package com.shile;


import com.sun.imageio.plugins.common.I18N;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // Change the program to allow players to type full words, or phrases, then move to the
    // correct location based upon their input.
    // The player should be able to type commands such as "Go West", "run South", or just "East"
    // and the program will move to the appropriate location if there is one.  As at present, an
    // attempt to move in an invalid direction should print a message and remain in the same place.
    // Single letter commands (N, W, S, E, Q) should still be available.

    private static Map<Integer, Location> locations;

    static {
        locations = new HashMap<Integer, Location>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0,"you are  sitting in front of computer learning java",null));

        tempExit.put("W",2);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("N",5);
        locations.put(1, new Location(1,"you are standing at the end of a road before a small brick building",tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("N",5);
        locations.put(2, new Location(2,"you are at the top of the hill",tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("W",1);
        locations.put(3, new Location(3,"you are inside a building, a well house fo ra small spring",tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("N",1);
        tempExit.put("W",2);
        locations.put(4, new Location(4,"you are in a valley beside a stream",tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("S",1);
        tempExit.put("W",2);
        locations.put(5, new Location(5,"you are in the forest",tempExit));


        Map<String,String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("NORTH","N");
        vocabulary.put("WEST","W");
        vocabulary.put("EAST", "E");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            // Locatation类中new HashMap(exits)可以避免被删除，we still have reference to the exits map for lcoatation 5
            tempExit.remove("S");
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }

            }
            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("you can't go in that direction");
            }

        }










    }
}
