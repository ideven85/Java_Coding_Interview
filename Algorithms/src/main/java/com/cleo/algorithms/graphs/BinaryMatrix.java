package com.cleo.algorithms.graphs;

public class BinaryMatrix {

    private static class Point{
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
            return -1;
        int src = grid[0][0];
        int n = grid.length,m=grid[0].length;
        Point source = new Point(0,0);
        Point destination=new Point(n-1,m-1);
        return -1;

    }

}
