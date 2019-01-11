package com.shile;

import java.io.Console;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "sydny");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Birsbane");
        addInOrder(placesToVisit, "perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);

        addInOrder(placesToVisit,"Alice Spring");
        addInOrder(placesToVisit,"Darwin");
        printList(placesToVisit);
        visit(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        // 这部分相当于一个for loop
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("=======================");

    }
    private static boolean addInOrder(LinkedList<String> LinkedList, String newCity) {
        // 按照字母顺序表进行排列
        ListIterator<String> stringListIterator = LinkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // 0 不加
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                // 按照字母排序，newcity应该排在前面
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                // 不用改变
            }
        }
        stringListIterator.add(newCity);
        return true;
    }
    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        // ListIterator 游标处在元素之间，所以只会得到previous，next，所以设置一个检查标志。The tortoise and the hare算法。
        boolean goingForward = true;
        boolean quit = false;
        ListIterator<String> listIterator = cities.listIterator();
        // .getFirst() == ""并不能检验string，会返回错误，应该用isEmpty
        if (cities.isEmpty()) {
            System.out.println("No city in the itenerary");
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Vocation over");
                    quit = false;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reach the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }
    private static void printMenu() {
        System.out.println("Available actions:\n press ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
    }
 }


