package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StairCaseTraversal {
    public static long staircase(int n) {
        //Your code goes here
        long answer=0;
        if(n==0)
            return 1;
        long[] dp = new long[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
       // System.out.println(Arrays.toString(dp));
        //return Arrays.stream(dp).sum();
        return dp[n];
    }

    private static final Map<Integer,Integer> memo = new HashMap<>();

    private static int dp(int n){
        if(n==0)
            return 1;
        else if(n<=2)
            return n;
        if(!memo.containsKey(n))
            memo.put(n,dp(n-1)+dp(n-2)+dp(n-3));
        return memo.get(n);
    }
    public static int climbStairs(int n) {
        return dp(n);
    }

    public static void main(String[] args) {
        System.out.println(staircase(4));
        System.out.println(climbStairs(4));
    }

}
