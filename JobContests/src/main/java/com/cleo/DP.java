package com.cleo;

import java.util.Map;

public class DP {

    private static Map<Integer>
    public static int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] dp = new int[rows];
        dp[0]=matrix[0][0];
        int column=0;
        int down=0,left=0,right=0;
        for (int i = 1; i < rows; i++) {
            down=matrix[i][column];
            /*if(column+1<columns)
                right=matrix[i+1][column+1];
            if(column>0)
                left=matrix[i-1][column-1];
            if(down>right&&down>left)
                dp[i]=down;
            else if(right>down&&right>left){
                dp[i]=dp[i-1]+right;
                column++;
            }else if(left>down&&left>right){
                dp[i]=dp[i-1]+left;
                column-=1;
            }
            down=left=right=0;*/





        }
    }
}
