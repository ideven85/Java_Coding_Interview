package com.cleo.java_coding_problems.dynamic;

import java.util.HashMap;
import java.util.Map;

public class MaximalScore {

    private int[][] memo;
    int n,m;
    int[] nums,multipliers;

    //dp(i, left)=max(mult⋅nums[left]+dp(i + 1, left + 1),
    // mult⋅nums[right]+dp(i + 1, left))
    private int dp(int i, int left){
        if(i==m)
            return 0;
        int right=n-1-(i-left);

        if(memo[i][left]==0)
            memo[i][left]=Math.max(multipliers[i]*nums[left]+dp(i+1,left+1),
                multipliers[i]*nums[right]+dp(i+1,left));
        return memo[i][left];
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums=nums;
        this.multipliers=multipliers;
        n=nums.length;
        m=multipliers.length;
        memo=new int[n][m];
        return dp(0,0);

    }

    public static void main(String[] args) {
        int[] nums={1,2,3};//3*3+2*2+1*1=14
        int[] multipliers={3,2,1};
        System.out.println(new MaximalScore().maximumScore(nums,multipliers));
    }
}
