package com.shile;

public class Main {

    /*deadLock occur because of order in which the Thread trying to acquire locks*/

    public static void main(String[] args) {
        final PolitePerson jane = new PolitePerson("jane");
        final PolitePerson john = new PolitePerson("john");

        new Thread(() -> jane.sayHello(john)).start();
        new Thread(() -> john.sayHello(jane)).start();

    }

    static class PolitePerson {
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s" + " has say hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s" + " he said hello back to me!%n", this.name, person.getName());
        }

    }

}
