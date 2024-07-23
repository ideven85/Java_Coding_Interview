package com.cleo.revision.old.dataStructures.graphs;

import java.util.*;

public class Djikstra {


    //nput:
    //V = 3, E = 3
    //adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}
    //S = 2
    //Output:
    //4 3 0
    // private static final Map<Integer,WeightedEdge> graph = new HashMap<>();
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        /*for (int i = 0; i < V; i++) {
            for(ArrayList<Integer> curr:adj.get(i)){

            }
            graph.put(i,new WeightedEdge());
        }*/
        /*int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                ArrayList<Integer> conn = adj.get(i).get(j);
                for (int weight : conn)
                    graph[i][j] = weight;
            }
        }*/
     /*   for (int[] row : graph) {
            System.out.println(Arrays.toString(row));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[S] = 0;
        boolean[] finished = new boolean[V];
        for (int count = 0; count < V; count++) {
            int u = -1;
            for (int i = 0; i < V; i++)
                if (!finished[i] && (u == -1 || distances[i] < distances[u]))
                    u = i;
            finished[u] = true;
            for (int v = 0; v < V; v++) {
                if (!finished[v] && (graph[u][v] != 0))
                    distances[v] = Math.min(distances[v], distances[u] + graph[u][v]);
            }
        }
        System.out.println(Arrays.toString(finished));
        return distances;*/
        return null;

    }

    static final int V = 4;

    public static int[] djikstra(int graph[][], int src) {

        int[] dist = new int[V];
        int res = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        boolean[] fin = new boolean[V];

        for (int count = 0; count < V - 1; count++) {
            int u = -1;

            for (int i = 0; i < V; i++)
                if (!fin[i] && (u == -1 || dist[i] < dist[u]))
                    u = i;
            fin[u] = true;

            for (int v = 0; v < V; v++)

                if (graph[u][v] != 0 && fin[v] == false)
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
        }
        return dist;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 50, 100, 0},
                {50, 0, 30, 200},
                {100, 30, 0, 20},
                {0, 200, 20, 0},};

        for (int x : djikstra(graph, 0)) {
            System.out.print(x + " ");
        }

    }
}