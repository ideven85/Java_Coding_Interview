package com.cleo.dataStructures.graphs;

import java.util.ArrayList;

public class CycleDirectedGraph {

    private static ArrayList<ArrayList<Integer>> adj;
    static void addEdge( int u, int v)
    {
        adj.get(u).add(v);
      //  adj.get(v).add(u);
    }

    private static boolean DFSRecursiveDirectedGraph(int node, boolean[] visited, boolean[] inRecursiveStack){
        visited[node]=true;
        inRecursiveStack[node]=true;
        for(int conn:adj.get(node)){
            if(!visited[conn]&&DFSRecursiveDirectedGraph(conn,visited,inRecursiveStack)){
                return true;

            }else if(inRecursiveStack[conn])
                return true;
        }
        inRecursiveStack[node]=false;
        return false;
    }

    private static boolean DFS(int V){
        boolean[] visited = new boolean[V];
        boolean[] inRecursiveStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                if(DFSRecursiveDirectedGraph(i,visited,inRecursiveStack))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int V = 6;
        adj=new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(0,1);
        addEdge(2,1);
        addEdge(2,3);
        addEdge(3,4);
        addEdge(4,5);
      //  addEdge(5,3);

        if(DFS(V))
            System.out.println("Cycle found");
        else
            System.out.println("No cycle found");
    }
}
