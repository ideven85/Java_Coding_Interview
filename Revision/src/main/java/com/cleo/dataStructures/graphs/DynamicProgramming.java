package com.cleo.dataStructures.graphs;

import java.util.Arrays;

class Fibonacci{
    private int N;

    protected long[] memo;


    public Fibonacci(int n) {
        N = n+1;
        memo = new long[N];
        Arrays.fill(memo,-1);
    }

    public long fib(int n){

        if(memo[n]==-1){
            long res;
            if(n == 0 || n == 1)
                return n;
            else
                res = fib(n-1)+fib(n-2);
            memo[n]=res;
        }
        System.out.println(Arrays.toString(memo));
        return memo[n];

    }

}

public class DynamicProgramming {
    public static String longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String max_str = "", curr_str;
        int max_length = 0, curr_length;

        for (int i = 0; i < str.length(); i++) {
            curr_str = expand(str, i, i);
            curr_length = curr_str.length();
            if (curr_length > max_length)
            {
                max_length = curr_length;
                max_str = curr_str;
            }
            curr_str = expand(str, i, i + 1);
            curr_length = curr_str.length();
            if (curr_length > max_length)
            {
                max_length = curr_length;
                max_str = curr_str;
            }

        }
        return max_str;
    }

    public static String expand(String str, int low, int high){

        while(low>=0 && high<str.length() && str.charAt(low)==str.charAt(high)) {
            low--;high++;
        }
        return str.substring(low+1,high);

    }
    public static void main(String[] args) {
        var fib = new Fibonacci(100);
       System.out.println(fib.fib(100));
        System.out.println(longestPalindrome("abb"));
    }

}
