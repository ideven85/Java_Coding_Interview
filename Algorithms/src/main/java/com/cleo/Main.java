package com.cleo;

public class Main {

    public static int factorial(int n){
        return n<2?1:n*factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println("Hi baby");
        System.out.println(factorial(10));
    }
}
