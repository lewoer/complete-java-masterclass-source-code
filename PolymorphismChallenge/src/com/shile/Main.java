package com.shile;


class Car {
    private boolean enigne;
    private int clylinders;
    private String name;
    private int wheels;

    public Car(int clylinders, String name) {
        this.clylinders = clylinders;
        this.name = name;
        this.wheels = 4;
        this.enigne = true;
    }

    public int getClylinders() {
        return clylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine(){
        return "Car -> startEngine";
    }
    public String accelerate() {
        return "Car -> accelerate";
    }

    public String brake() {
        return "Car -> brake()";
    }
}

class Mitsubishi extends Car {
    public Mitsubishi(int clylinders, String name) {
        super(clylinders, name);
    }

    @Override
    public String startEngine() {
        return "Mitsubishi -> startEngine";;
    }

    @Override
    public String accelerate() {
        return super.accelerate();
    }

    @Override
    public String brake() {
        return super.brake();
    }
}
public class Main {

    public static void main(String[] args) {
        // We are going to go back to the car analogy.
        // Create a base class called Car
        // It should have a few fields that would be appropriate for a generice car calss.
        // engine, cylinders, wheels, etc.
        // Constructor should initialize cylinders (number of) and name, and set wheels to 4
        // and engine to true. Cylinders and names would be passed parameters.
        //
        // Create appropriate getters
        //
        // Create some methods like startEngine, accelerate, and brake
        //
        // show a message for each in the base class
        // Now create 3 sub classes for your favorite vehicles.
        // Override the appropriate methods to demonstrate polymorphism in use.
        // put all classes in the one java file (this one).    }
}


