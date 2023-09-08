package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

public class FindWinner {

    public static String findWinner(int n, int x, int y) {
        //Your code goes here
        String winner1="Beerus",winner2="Whis";
        int[] denoms = {1,x,y};
       // Arrays.sort(denoms);
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
      /*  dp[0]=0;
        int toCompare=0;
        for(int denom:denoms){
            for (int i = 0; i < dp.length; i++) {
                if(denom<=i) {

                    if(dp[i-denom]==Integer.MAX_VALUE)
                        toCompare=Integer.MAX_VALUE;
                    else
                        toCompare=dp[i-denom]+1;
                    dp[i]=Math.min(dp[i],toCompare);
                }
            }

        }
        System.out.println(Arrays.toString(dp));

       */


        return dp[n]==dp[n-1]?winner1:winner2;

      //  return winner1;
    }

    public static void main(String[] args) {
        int n=4,x=1,y=2;
        System.out.println(findWinner(n,x,y));
    }
}
