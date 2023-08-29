package com.cleo.algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs{
    Map<Integer,Integer> map = new HashMap<>();

    public int minCostClimbingStairsMemoised(int[] cost) {
        return minCostClimbingStairs(0,cost);

    }
    private  int minCostClimbingStairs(int position,int[] cost){
        if(position>=cost.length)
            return 0;
        if(map.get(position)!=null)
            return map.get(position);

        int answer = Math.min(minCostClimbingStairs(position+1,cost)+cost[position],minCostClimbingStairs(position+2,cost)+cost[position]);
        map.put(position,answer);
        return answer;

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n==1)return cost[0];
        int[] dp = new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for (int i = 2; i < n; i++) {
            dp[i]=Math.min(cost[i]+dp[i-1],cost[i]+dp[i-2]);



        }
          System.out.println(Arrays.toString(dp));
        return Math.min(dp[n-1],dp[n-2]);

    }

    public static void main(String[] args) {
        /**
         * Min Cost Climbing Stairs
         */

        System.out.println("\nMin cost Climbing Stairs\n");
        MinCostClimbingStairs minCost = new MinCostClimbingStairs();
        System.out.println(minCost.minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(minCost.minCostClimbingStairsMemoised(new int[]{10,15,20}));

    }
}
