package com.cleo.java_coding_problems.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCS {

    private   int[][] memo;
    String first;
    String second;
    int n,m;
    private int dp(int n,int m){
        boolean b = first.charAt(n) == second.charAt(m);
        if(n==0||m==0)
            return b ?1:0;
        if(b)
            memo[n][m]=1+dp(n-1,m-1);
        else
            memo[n][m]=Math.max(dp(n-1,m-1),Math.max(dp(n,m-1),dp(n-1,m)));
        return memo[n][m];

    }
    public  int lcs(String s1,String s2){
        first=s1;
        second=s2;
        n=s1.length();
        m=s2.length();
        if(n*m==0)
            return 0;
        memo=new int[n][m];

       return dp(n-1,m-1);

    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(),m=text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],Math.max(dp[i][j-1],dp[i-1][j-1]));
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        String s1="abc";
        String s2="aaec";
        System.out.println(longestCommonSubsequence(s1,s2));
      LCS lcs=new LCS();
        System.out.println(lcs.lcs(s1,s2));
        for(var row:lcs.memo)
            System.out.println(Arrays.toString(row));

    }
}
