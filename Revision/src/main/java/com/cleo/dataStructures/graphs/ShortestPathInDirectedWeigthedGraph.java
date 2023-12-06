package com.cleo.dataStructures.graphs;

import java.util.*;

class EdgeWeight{

    int destination;
    int weight;
    public EdgeWeight(int destination, int weight){
        this.destination=destination;
        this.weight=weight;
    }
}

/**
 * To find the shortest path from source to every other vertex in a directed
 * acyclic weighted graph
 */
public class ShortestPathInDirectedWeigthedGraph {


    private static final Map<Integer, List<EdgeWeight>> graph= new HashMap<>();
    private static final int source=0;
//O/
//Source : O
//0,2,3,6,1,5
//[0, 2, 5, 13, 1, 4]
    private static void addEdge(int source, int destination,int distance){
        EdgeWeight edge = new EdgeWeight(destination, distance);
        graph.get(source).add(edge);
    }

    private static List<Integer> topologicalSort(int V){
        List<Integer> topologicallySorted = new ArrayList<>();
        int[] in_degree = new int[V];
        //Arrays.fill(in_degree,Integer.MAX_VALUE);
        for (int i = 0; i < V; i++) {
          for(EdgeWeight node:graph.get(i))
              in_degree[node.destination]++;
        }
        in_degree[source]=0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int current=queue.poll();
           topologicallySorted.add(current);
            for(var conn:graph.get(current)){
                int destination= conn.destination;
                if(in_degree[destination]>0)
                    in_degree[destination]--;
                if(in_degree[destination]==0)
                    queue.add(destination);
            }
        }
       // System.out.println(topologicallySorted);
        return topologicallySorted;
    }

    private static List<Integer> shortestPathFromSourceToEveryVertex(int V){
        List<Integer> output = new ArrayList<>();
        int[] shortestDistances = new int[V];
        List<Integer> topologicalSorting=topologicalSort(V);
        //System.out.println(topologicalSorting);
        Arrays.fill(shortestDistances,Integer.MAX_VALUE);
        shortestDistances[source]=0;
        Queue<Integer> queue = new LinkedList<>(topologicalSorting);
        while(!queue.isEmpty()){
            int current=queue.poll();
            for(EdgeWeight edge:graph.get(current)){
                int destination= edge.destination;
                int weight=edge.weight;

                if(shortestDistances[destination]>shortestDistances[current]+weight)
                    shortestDistances[destination]=shortestDistances[current]+weight;

             //   queue.add(destination);
                System.out.println(Arrays.toString(shortestDistances));
            }
        }
        for(int num:shortestDistances)
            output.add(num);
        return output;

    }
    public static void main(String[] args) {
        int V = 6;
        for (int i = 0; i < V; i++) {
            graph.put(i,new ArrayList<>());
        }
        addEdge(0,1,2);
        addEdge(0,4,1);
        addEdge(1,2,3);
        addEdge(4,2,2);
        addEdge(2,3,6);
        addEdge(4,5,4);
        addEdge(5,3,1);
        //0,2,3,6,1,5
//[0, 2, 5, 13, 1, 4]
        //[0, 2, 3, 6, 1, 5]
        System.out.println(shortestPathFromSourceToEveryVertex(V));
    }
}
