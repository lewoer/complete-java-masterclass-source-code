package com.shile;

import java.util.*;

/**
 * 1. variable declared outside of the anonymous class should be final
 *   if we want to access within anonymous class.
 * */
public class Main {

    public static void main(String[] args) {
//        Employee john = new Employee("john",30);
//        Employee tim = new Employee("tim",87);
//        Employee jack = new Employee("jack",32);
//        Employee snow = new Employee("snow",21);
//
//        List<Employee> employees = new ArrayList<>();
//        employees.add(john);
//        employees.add(tim);
//        employees.add(jack);
//        employees.add(snow);
//
////        Collections.sort(employees, new Comparator<Employee>() {
////            @Override
////            public int compare(Employee employee1, Employee employee2) {
////                return employee1.getName().compareTo(employee2.getName());
////            }
////        });
//        Collections.sort(employees,(employee1, employee2) ->
//                employee1.getName().compareTo(employee2.getName()));
//
//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//        }
//
////        String sillyString = doStringStuff(new UpperConcat() {
////            @Override
////            public String upperAndConcat(String s1, String s2) {
////                return s1.toUpperCase() + s2.toUpperCase();
////            }
////        },
////        employees.get(0).getName(),employees.get(1).getName());
////        System.out.println(sillyString);
//        UpperConcat uc = (s1,s2)-> {
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//        String sillyString = doStringStuff(uc,employees.get(0).getName(),employees.get(1).getName());
//        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSometing();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1,s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat{
    String upperAndConcat(String s1, String s2);
}

class AnotherClass{
    public String doSometing(){

        int i =0;
        UpperConcat uc = (s1,s2) -> {
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        System.out.println("The AnotherClass name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc,"String1","String2");
    }
}