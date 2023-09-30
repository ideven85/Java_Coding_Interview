package com.cleo.algorithms.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapSack {
    public static List<List<Integer>> knapsackProblem(
            int[][] items, int capacity
    ) {
        // Write your code here.
        // Replace the code below.
        int n = items.length;
        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i]=items[i][0];
            values[i]=items[i][1];
        }
        int[] dp = new int[n];

        List<Integer> totalValue = Arrays.asList(10);
        List<Integer> finalItems = Arrays.asList(1, 2);
        var result = new ArrayList<List<Integer>>();
        result.add(totalValue);
        result.add(finalItems);
        return result;
    }
}
