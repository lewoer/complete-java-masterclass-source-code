package com.shile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N35",
                "B12", "B6",
                "G53", "G49", "G60", "G45", "g64",
                "I26", "I17", "I29",
                "O19"
        );

        List<String> gNumber = new ArrayList<>();

        someBingoNumbers.stream()
                .map(String::toUpperCase)  // 方法引用: 使用lambda调用已经存在的方法
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);  // forEach不返回值,所以看作是terminal operation

        /*create stream from scratch*/

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "091");
        Stream<String> inNumberStram = Stream.of("N49", "N36", "I26", "I17", "I29", "091");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStram);
        System.out.println("----------------------");
        System.out.println(concatStream.
                distinct()
                .peek(System.out::println)  //
                .count());


        Employee john = new Employee("John Doe",30);
        Employee jane = new Employee("Jane Deer",25);
        Employee jack = new Employee("Jack Hill",40);
        Employee snow = new Employee("Snow Shite",22);

        Department hr = new Department("Human Resource");
        hr.addEmployee(jack);
        hr.addEmployee(jane);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("-------------------");
//        List<String> sortedGNumber = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s->s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());
        List<String> sortedGNumber = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        for (String s : sortedGNumber) {
            System.out.println(s);
        }

        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() <  e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        Stream.of("ABC","SFSA","ASD","ASDAS")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() > 3;
                })
                .count();





//        someBingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")) {
//                gNumber.add(number);
////                System.out.println(number);
//            }
//        });
//
//        gNumber.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumber.forEach((String s) -> System.out.println(s));
    }
}
