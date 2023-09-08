package com.cleo.algorithms.graphs;


// TODO: 10/08/23  
public class ShortestBridge {

    /**
     *
     * @param grid You are given an n x n binary matrix grid where 1
     *                 represents land and 0 represents water.
     * An island is a 4-directionally connected group of 1's not
     *  connected to any other 1's. There are exactly two islands in grid.
     * @return  You may change 0's to 1's to connect the two islands to
     * form one island.
     *  Return the smallest number of 0's you must flip to connect the two islands.
     */
    public  int shortestBridge(int[][] grid) {
        return 0;

    }

    public static void main(String[] args) {
        ShortestBridge bridge = new ShortestBridge();
        int[][] grid = {{0,1},{1,0}};
        System.out.println(bridge.shortestBridge(grid));
    }
}
