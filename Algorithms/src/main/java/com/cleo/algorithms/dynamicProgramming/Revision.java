package com.cleo.algorithms.dynamicProgramming;

public class Revision {

    public  static int climbStairs(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        else
            return climbStairs(n-1)+climbStairs(n-2);

    }



    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }
}
