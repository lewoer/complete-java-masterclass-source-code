package com.shile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("john Doe", 30);
        Employee tim = new Employee("tim Buchaka", 87);
        Employee jack = new Employee("jack Hill", 32);
        Employee snow = new Employee("snow kill", 21);
        Employee bed = new Employee("bed bou", 35);
        Employee red = new Employee("red lope", 19);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(bed);
        employees.add(red);

        Function<Employee,String> getLastName = (Employee employee)-> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };
        String LastName = getLastName.apply(employees.get(1));
        System.out.println(LastName);

        Function<Employee,String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0,employee.getName().indexOf(' '));
        };

        Random random1 = new Random();
        for (Employee employee : employees) {
            if (random1.nextBoolean()) {
                System.out.println(getAName(getFirstName,employee));
            } else {
                System.out.println(getAName(getLastName,employee));
            }
        }



//        // 使用Predicate函数接口,接受一个参数,返回一个boolean值.
//        printEmployeeByAge(employees,"Employee over 30", employee -> employee.getAge() > 30);
//        printEmployeeByAge(employees,"Employee 30 and under", employee -> employee.getAge() <= 30);
//        printEmployeeByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getAge() < 25;
//            }
//        });
//
//        IntPredicate greaterThan15 = i -> i > 15;
//        IntPredicate lessThan100 = i -> i < 100;
//        // lambda在闭包内,所以可以用相同的名字.并连接到一起
//        System.out.println(greaterThan15.and(lessThan100).test(50));
//        System.out.println(greaterThan15.and(lessThan100).test(15));
//
//        Random random = new Random();
//        /*使用Supplier作为counter*/
//        Supplier<Integer> randomSuplier = () -> random.nextInt();
//        for (int i=0; i<20; i++) {
//            System.out.println(randomSuplier.get());
//        }
//
        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println("Last name is : " + lastName);
        });


    }



    private static void printEmployeeByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
