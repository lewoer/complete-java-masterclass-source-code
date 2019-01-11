package com.shile;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 15:05 2019/1/1
 */
public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> lanuage = new HashMap<>();
        lanuage.put("Java", "a complied high level, object-oriented, platform independent language");
        lanuage.put("python", "an interpreted, object-oriented, high-level programing language with dynamic sematic");
        lanuage.put("Algol", "an algorithm language");
        System.out.println(lanuage.put("BASIC", "Beginner All Propose Symbolic Instruction code"));
        System.out.println(lanuage.put("Lisp", "therein lies madness"));

        if (lanuage.containsKey("Java")) {
            System.out.println("java is already in the map");
        } else {
            lanuage.put("java", "this course is about java");
        }

        System.out.println("=======================");
//        lanuage.remove("Lisp");

        if (lanuage.remove("Algol", "an algorithm language")) {
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key/value not found");
        }

        if (lanuage.replace("Lisp","therein lies madness",
                "a functional programming language with imperative feature")) {
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp was not replaced");
        }
//        System.out.println(lanuage.replace("Scala","this will not be added"));


        for (String key : lanuage.keySet()) {
            System.out.println(key + " : " + lanuage.get(key));
        }


    }
}
