package com.cleo.backtracking;

import java.util.Arrays;

public class RatInAMaze {
    public static boolean ratInAMaze(int[][] maze){
        int N = maze.length;
        int[][] visited=new int[N][N];

       boolean flag=solveMaze(maze,N-1,N-1,0,0,visited);
     /*   for(int[] row:visited)
            System.out.println(Arrays.toString(row));
    */    return visited[N-1][N-1]==1;
    }
    private static boolean solveMaze(int[][] maze, int rows, int columns, int row, int column,int[][] visited){
        boolean flag=false;

        if(row==rows&&column==columns&&maze[row][column]==1) {
            visited[row][column]=1;
            return true;
        }
        if(visited[row][column]==1)
            return false;
        visited[row][column]=1;
        if(maze[row][column]==0)
            return false;

        for(int[] r:visited){
          //  System.out.println(Arrays.toString(r));
         if(Arrays.stream(r).anyMatch(c->c==0)) {
             flag = true;
             break;
         }




     }
       // System.out.println("Hi");


            if (row < rows && visited[row + 1][column] == 0) {
                solveMaze(maze, rows, columns, row + 1, column, visited);
                return true;
            }

             if (column < columns && visited[row][column + 1] == 0) {
                 solveMaze(maze, rows, columns, row, column + 1, visited);
                 return true;
             }
             if (row > 0 && visited[row - 1][column] == 0){
                solveMaze(maze, rows, columns, row - 1, column, visited);
        return true;
    }
             if (column > 0 && visited[row][column - 1] == 0){

                 solveMaze(maze, rows, columns, row, column - 1, visited);
               return true;
}

             return false;

        }




    public static void main(String[] args) {
        int[][] maze={{1,1,0},
                {1,0,0},
                {0,1,1}};
        System.out.println(ratInAMaze(maze));
    }
}
