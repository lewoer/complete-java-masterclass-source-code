package com.shile;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // 如果类所在的package不一致，可以直接将它拖入到main，这样就自动重构了

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();


    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter you choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
                case 7:
                    processArrayList();
                    break;

            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To print choice oprions.");
        System.out.println("\t 1 - To print the list of the grocery items");
        System.out.println("\t 2 - To add an item to a list ");
        System.out.println("\t 3 - To modify the item in the list");
        System.out.println("\t 4 - To remove the item from the list");
        System.out.println("\t 5 - To search for item in the list");
        System.out.println("\t 6 - To quit the application");
    }

    public static void addItem() {
        System.out.print("Please Enter the grocery item ");
        groceryList.addGroceryItems(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.println("Current item name");
        String itemNo = scanner.nextLine();
        System.out.print("Enter replace item");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);

    }

    public static void removeItem() {
        System.out.println("Enter item name");
        String itemNo = scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    public static void searchForItem() {
        // 直接搜索值可以使我们避开索引，避免+—1的错误。
        System.out.println("Enter to search item ");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " is not in our grocery list");
        }

    }

    public static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());
        // 直接初始化Arraylist
        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());

        // convert array list to regular array
        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }

}
