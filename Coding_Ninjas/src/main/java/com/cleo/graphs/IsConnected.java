package com.cleo.graphs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class IsConnected {

    public static void dftraversal(int[][] adjMatrix,int currVertex, boolean[] visited){
        visited[currVertex] = true;
        for(int i=0;i<adjMatrix.length;i++){
            if(adjMatrix[currVertex][i]==1 && !visited[i]){
                dftraversal(adjMatrix,i,visited);
            }
        }
    }

    public static boolean dftraversal(int[][] adjMatrix){
        boolean[] visited = new boolean[adjMatrix.length];
        dftraversal(adjMatrix,0,visited);
        for (boolean b : visited) if (!b) return false;
        return true;
    }

    public static void main(String[] args)  throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        if (n==0) {
            System.out.println(true);
            return;
        }
        int[][] adjMatrix = new int[n][n];
        for(int i=0;i<e;i++){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        System.out.println(dftraversal(adjMatrix));
    }
}