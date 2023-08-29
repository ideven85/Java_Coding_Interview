package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;

class EditDistance1 {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n>m) {

            int starting_index = word1.indexOf(word2.charAt(0));
            int ending_index = word1.indexOf(word2.charAt(m-1));
            return starting_index+(n-ending_index);

        }else{

            int starting_index = word2.indexOf(word1.charAt(0));
            int ending_index = word2.indexOf(word1.charAt(n-1));
            return starting_index+(m-ending_index+1);
        }
    }

    //Max speed
    //Min Memory Usage
    public int minDistanceV2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;

                else if (j == 0)
                    dp[i][j] = i;

                else if (word1.charAt(i - 1)
                        == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                else
                    dp[i][j] = 1
                            + Math.min(dp[i][j - 1],
                            Math.min(dp[i - 1][j],
                                    dp[i - 1]
                                            [j - 1]));
            }
        }
        return dp[m][n];
    }
}

public class LevenshteinDistance {


    public int minDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);

        return f(n,m,str1,str2,dp);
    }

    public int f(int i,int j,String word1, String word2,int dp[][] ){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1)return dp[i][j];

        if(word1.charAt(i-1)==word2.charAt(j-1))
            return dp[i][j]= f(i-1,j-1,word1,word2,dp);

        int insert = 1+f(i,j-1,word1,word2,dp);
        int delete = 1+f(i-1,j,word1,word2,dp);
        int replace = 1 + f(i-1,j-1,word1,word2,dp);

        return  dp[i][j]= Math.min(insert,Math.min(delete,replace));
    }



    public static void main(String[] args) {
        String word1 = "leetcode", word2 = "etco";
        System.out.println(new LevenshteinDistance().minDistance(word1,word2));
        EditDistance1 distance1 = new EditDistance1();
        LevenshteinDistance distance = new LevenshteinDistance();
        System.out.println(distance.minDistance(word1,word2));
        System.out.println(distance1.minDistanceV2(word1,word2));
    }
}
