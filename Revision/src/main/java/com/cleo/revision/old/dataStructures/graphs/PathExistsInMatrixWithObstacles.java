package com.cleo.revision.old.dataStructures.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// TODO: 04/12/23
public class PathExistsInMatrixWithObstacles {
    class Point{
        int x,y;
        int x(){
            return x;
        }
        int y(){
            return y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            assert obj instanceof Point;
            Point p = (Point) obj;
            return x==p.x&&y==p.y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
    private int[][] grid;

    public boolean is_Possible(int[][] grid)
    {
        this.grid=grid;
        // Code here
        Point source=new Point(-1,-1),destination=new Point(-1,-1);


        boolean flag1=false,flag2=false;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if(grid[i][j]==1) {
                    source = new Point(i, j);
                    flag1=true;
                }
                if(grid[i][j]==2) {
                    destination = new Point(i, j);
                    flag2=true;
                }
            }
            if(flag1&&flag2)
                break;
        }
        System.out.println(source);
        System.out.println(destination);
        int distance= Math.abs(source.x-destination.x)+Math.abs(source.y-destination.y);
        Set<Point> visited = new HashSet<>();

        return dfsFromSource(source, destination,visited,distance);

    }

    private boolean dfsFromSource(Point source, Point destination,Set<Point> visited,int distance){
        if(source.equals(destination))
            return true;


        List<Point> connections = getReachableCells(source,visited);

        System.out.println(connections);
        if(!connections.isEmpty()) {
            for (Point conn : connections) {
                if (visited.contains(conn))
                    continue;
                if (conn.equals(destination))
                    return true;
                visited.add(conn);
                if (dfsFromSource(conn, destination, visited, distance))
                    return true;

            }
        }

        return source.equals(destination);
    }
    private List<Point> getReachableCells(Point node, Set<Point> visited){
        int n= grid.length,m=grid[0].length;

        List<Point> connections=new ArrayList<>();
        int x=node.x(),y=node.y();
        Point left=new Point(x-1,y);
        Point right=new Point(x+1,y);
        Point up = new Point(x,y-1);
        Point down=new Point(x,y+1);
        if(x>0&& !(grid[x-1][y] ==0))
            connections.add(left);
        if(x+1<n&& !(grid[x+1][y] ==0))
            connections.add(right);
        if(y>0&&!(grid[x][y-1] ==0))
            connections.add(up);
        if(y+1<m&&!(grid[x][y+1] ==0))
            connections.add(down);
        return connections;
    }

    public static void main(String[] args) {
        //8
        //3 3 3 3 0 0 3 0
        //1 3 3 3 3 3 3 2
        //3 3 0 3 0 3 3 3
        //3 3 3 0 0 3 3 0
        //0 3 3 3 3 3 3 3
        //0 0 0 3 3 0 3 3
        //0 3 0 3 3 3 3 0
        //3 3 3 0 3 3 3 3
        int[][] grid={{3,0,3,0,0},{3,0,0,0,3}
                ,{0,2,3,0,0},{3,3,3,1,3}};
        PathExistsInMatrixWithObstacles pathExistsInMatrixWithObstacles = new PathExistsInMatrixWithObstacles();
        System.out.println(pathExistsInMatrixWithObstacles.is_Possible(grid));
    }
}
