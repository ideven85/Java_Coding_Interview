package com.cleo.revision.old.dataStructures.graphs;

import java.util.*;

public class TopologicalSorting {

    private static final Map<Integer,List<Integer>> graph = new HashMap<>();

    //BFS Based Solution
    public static List<Integer> topologicalSorting(int V){
        List<Integer> output = new ArrayList<>();
        int[] in_degree=new int[V];
        for (int i = 0; i < V; i++) {
            for(int node:graph.get(i))
                in_degree[node]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        //boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(in_degree[i]==0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int current=queue.poll();

           // visited[current]=true;
            output.add(current);
            List<Integer> adjacent=graph.get(current);
            if(!adjacent.isEmpty()){
                for(int conn:adjacent){
                   if(in_degree[conn]>0)
                       in_degree[conn]--;
                   if(in_degree[conn]==0)
                       queue.add(conn);

                }
            }

        }
        return output;

    }

    public static void main(String[] args) {
        int V=5;
        for (int i = 0; i < V; i++) {
            graph.put(i,new ArrayList<>());
        }
        graph.get(0).addAll(List.of(2,3));
        graph.get(2).add(3);
        graph.get(3).add(4);//Now 4 is dependent on 3
        graph.get(1).addAll(List.of(3,4));
        System.out.println(topologicalSorting(V));
    }
}
