package com.cleo.algorithms.graphs;

import java.util.*;

public class MinPrice {

    private static class Connections{
        int destination;
        int fair;

        public Connections(int destination, int cost) {
            this.destination = destination;
            this.fair = cost;
        }
    }

    private final Map<Integer, List<Connections>> graph = new HashMap<>();

    ///Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],
    // [2,3,200]], src = 0, dst = 3, k = 1
    //Output: 700
    //The optimal path with at most 1 stop from city 0 to 3 [0,1,3]
   // has cost 100 + 600 = 700.
    //Note that the path through cities [0,1,2,3] is cheaper
    // but is invalid because it uses 2 stops.
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        for (int i = 0; i < n; i++) {
            graph.put(i,new ArrayList<>());
        }
        for(int[] flight:flights){
            int source=flight[0];
            int destination=flight[1];
            int fair=flight[2];
            graph.get(source).add(new Connections(destination,fair));
        }
        Queue<Connections> queue = new LinkedList<>();
        for(int node:graph.keySet()){
            graph.get(node).sort((a, b) -> a.fair - b.fair);
        }
        queue.add(new Connections(src,0));
        int stops=0;
        int total_fair=0;
        while(!queue.isEmpty()){
            Connections node = queue.poll();
            int currentNode=node.destination;
            int currentFair=node.fair;
            //I am thinking breadth first search will give me the answer
            stops+=1;

            List<Connections> connections = graph.get(currentNode);

            for(Connections connection:connections){
                int currentConnection=connection.destination;
                int fair=connection.fair;


            }
        }

        return total_fair;

    }

}
