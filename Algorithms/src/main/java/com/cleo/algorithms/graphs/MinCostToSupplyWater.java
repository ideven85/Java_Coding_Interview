package com.cleo.algorithms.graphs;


//LeetCode Hard Problem 1168

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: 08/09/23  
public class MinCostToSupplyWater {
    static class City{
        int houseNumber;
        int cost_of_well;

        boolean containsWell=false;

        boolean is_connected_to_all_cities=false;

        List<Integer> remaining_cities;


    }
    Map<Integer,List<City>> cityGraph = new HashMap<>();
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {



        return 0;


    }
}
