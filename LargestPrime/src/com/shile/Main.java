package com.shile;

public class Main {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(217));
        System.out.println(getLargestPrime(0));
        System.out.println(getLargestPrime(45));
        System.out.println(getLargestPrime(1));
        System.out.println(getLargestPrime(-1));

    }

    public static int getLargestPrime(int number){
        if(number < 2){
            return -1;
        }
        for(int i = 2; i < number; i++){
            if(number % i == 0) {
                int factor = number / i;
                boolean factorPrime = true;
                for(int j = 2; j < factor; j++){
                    if(factor % j == 0) {
                        factorPrime = false;
                    }
                }
                if(factorPrime){
                    return factor;
                }
            }
        }
        return number;
    }
}
