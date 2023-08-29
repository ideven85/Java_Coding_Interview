package com.cleo.algorithms.leetcodePremium;

import java.util.stream.IntStream;

public class Fibonacci {

    public static int helper(int n){
        int a=0,b=1;
        for (int i = 1; i < n; i++) {
            b+=a;
            a=b-a;
        }
        return b;
    }
    public static int compute(int n) {
        return switch (n) {
            case 0 -> 0;
            case 1 -> 1;
            default -> helper(n);


        };
    }

    public static void main(String[] args) {
        var s = IntStream.rangeClosed(0, 45).toArray();
        for(int i:s){
            System.out.println(i+":"+compute(i));
        }
        
    }
}
