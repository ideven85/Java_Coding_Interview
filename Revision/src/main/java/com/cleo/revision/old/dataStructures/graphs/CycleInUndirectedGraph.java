package com.cleo.revision.old.dataStructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleInUndirectedGraph {

    private ArrayList<ArrayList<Integer>> graph;


    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        graph=adj;
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i])
                if(cycleDetectedDFSRecursive(i,visited,-1))
                    return true;
        }
     //   System.out.println(Arrays.toString(visited));

        return false;

    }

    private boolean cycleDetectedDFSRecursive(int source, boolean[] visited, int parent){
        visited[source]=true;
        for(int conn:graph.get(source)){
            if(!visited[conn]) {
                if (cycleDetectedDFSRecursive(conn, visited, source))
                    return true;
            }
            else if (conn != parent)
                    return true;


        }
     //   System.out.println(Arrays.toString(visited));
        return false;
    }

    public static void main(String[] args) {
        int V=5;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).addAll(List.of(0,2,4));
        graph.get(2).addAll(List.of(1,3));
        graph.get(3).add(2);
        graph.get(4).add(1);
        CycleInUndirectedGraph cycle = new CycleInUndirectedGraph();
        System.out.println(cycle.isCycle(V,graph));
    }
}