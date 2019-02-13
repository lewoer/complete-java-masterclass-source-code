package com.shile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    /**
     * challenge #1: anonymous to lambda expression
     * challenge #2: write the following method as a lambda expression
     * challenge #3: execute the function with the argument of "123456789
     * challenge #4: instead of execute the function directly, supposed we want to pass it to a method named everySecondCharacter
     *              that accepted the function as a parameter and execute it with the argument 123456789
     * challenge #5: using the bonus version, call the method with the lambdaFunction we created ealier and the String "123456789".print the result
     *              return from the method.
     * challenge #6: write a lambda expression that map to java.util.Supplier interface. this lambda should return the string
     *              "I love java",Assign it a variable called iLoveJava
     * challenge #7: use Supplier to assign the String "i love you" to a variable called supplierResult. Then print the variabel
     *              to teh console.
     *
     * challenge #8: Given a specific interface, how can we tell whether we can map a interface to it? What's the criteria has to be met.
     *      The answer :the interface has to be functional interface .It can has only a single method that has to be implemented.
     * challenge #9:
     * */

    public static void main(String[] args) {
	// challenge #1: anonymous to lambda expression

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an string";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Runnable runable = () -> {
            String myString = "Let's split this up into an string";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        /*challenge #2: write the following method as a lambda expression*/
        Function<String,String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i=0; i<s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        /* challenge #3: execute the function with the argument of "123456789"*/

//        System.out.println(lambdaFunction.apply("123456789"));

        // challenge #5
        String result = everySecondCharacter(lambdaFunction,"123456789");
        System.out.println(result);

        // challenge #6
//        Supplier<String> iLoveJava = () -> "i love java";
        Supplier<String> iLoveJava = () -> {return "i love java";};

        // challenge #7
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);


        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name -> {
            firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1));
        });
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        System.out.println("-----------");
        topNames2015.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted()
                .forEach(System.out::println);

        long namesBeginningWithA = topNames2015.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(name ->name.startsWith("A"))
                .count();

        System.out.println("Numbers of name begining with A" + namesBeginningWithA);

        // Stream chain is lazy evaluated
        topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());




    }

     /*challenge #2: write the following method as a lambda expression*/

//    public static String everySecondChar(String source) {
//        StringBuilder returnVal = new StringBuilder();
//        for (int i=0; i<source.length(); i++) {
//            if (i % 2 == 1) {
//                returnVal.append(source.charAt(i));
//            }
//        }
//        return returnVal.toString();
//    }

    // challenge #4
    private static String everySecondCharacter(Function<String,String> func, String source) {
        return func.apply(source);
    }



}
