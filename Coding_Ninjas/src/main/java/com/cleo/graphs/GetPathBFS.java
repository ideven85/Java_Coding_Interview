package com.cleo.graphs;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class GetPathBFS {
    public static void BFTraversal(int[][] adjMatrix, int v1, int v2) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        boolean[] visited = new boolean[adjMatrix.length];
        queue.add(v1);
        visited[v1] = true;
        hashMap.put(v1,-1);
        while (!queue.isEmpty()) {
            if (queue.peek() == v2) {
                int i = queue.peek();
                while (i != -1) {
                    arrayList.add(i);
                    i = hashMap.get(i);
                }
                for (int j :arrayList) System.out.print(j+" ");
                return;
            }
            for (int i = 0; i < visited.length; i++) {
                if (adjMatrix[queue.peek()][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    hashMap.put(i,queue.peek());
                }
            }
            queue.poll();
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        if (n == 0) return;
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < e; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        int v1 = scanner.nextInt();
        int v2 = scanner.nextInt();
        if (v1 < 0 || v1 >= adjMatrix.length || v2 < 0 || v2 >= adjMatrix.length) {
            return;
        }
        BFTraversal(adjMatrix,v1,v2);
    }
}