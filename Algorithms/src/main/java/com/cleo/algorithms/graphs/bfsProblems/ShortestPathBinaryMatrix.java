package com.cleo.algorithms.graphs.bfsProblems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: 24/08/23 "Using BFS or DFS or dynamic"
/**
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected
 * (i.e., they are different and they share an edge or a corner).
 */
public class ShortestPathBinaryMatrix {

    private static class Node{
        int row;
        int column;



        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    private int[][] grid;
    private int n;

    private final Map<Node, List<Node>> graph = new HashMap<>();
    public int shortestPathBinaryMatrix(int[][] grid) {
        this.grid=grid;
        int n=grid.length;
        createGraph(grid);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if(isCorner(row,col)){
                    if(grid[row][col]==0){

                    }
                }
            }
        }
        return -1;

    }
    private boolean isCorner(int row, int column){
        return row==0||row==n-1||column==0||column==n-1;
    }

    private void createGraph(int[][] grid){
        int n = grid.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(grid[row][col]==0){
                    if(isConnected(row,col)){
                        Node node = new Node(row,col);

                    }
                }

            }

        }
    }
    private boolean isConnected(int row, int col){
        if(row>0)
            return grid[row-1][col]!=0;

        if(col>0)
            return grid[row][col-1]!=0;

        if(row+1<n)
            return grid[row+1][col]!=0;

        if(col+1<n)
            return grid[row][col + 1] != 0;
        if(row>0&&col>0)
            return grid[row-1][col-1]!=0;
        if(row+1<n&&col+1<n)
            return grid[row+1][col+1]!=0;
        if(row+1<n&&col>0)
            return grid[row+1][col-1]!=0;
        if(row-1>0&&col+1<n)
            return grid[row-1][col+1]!=0;

        return false;

    }
}
