package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

public class NumberOfCoinsForChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int[] dp = new int[n+1];
        dp[0]=1;
        int ways = 0;
        //Top-Down Approach
        for(int denom:denoms){
            for (int amount = 1; amount <=n; amount++) {
                if(denom<=amount)
                    dp[amount]+=dp[amount-denom];
                System.out.println(Arrays.toString(dp));

            }
        }


        //     return recur(n,denoms,0);//Alternative Solution using memoization
        return dp[n];

    }

    public static void main(String[] args) {
        int n=5;int[] denominations={1,2,5};
        System.out.println(numberOfWaysToMakeChange(n,denominations));
    }
}
