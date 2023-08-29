package com.cleo.algorithms.dynamicProgramming;

// TODO: 22/01/23  
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n = s.length(),m=t.length();
        if(n==m){
            if(s.equals(t))
                return 1;
            else
                return 0;
        }
        int[][] dp = new int[n+1][m+1];
        int count=0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {



        }
        return count;

    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        DistinctSubsequences subsequences = new DistinctSubsequences();
        System.out.println(subsequences.numDistinct(s,t));
    }
}
