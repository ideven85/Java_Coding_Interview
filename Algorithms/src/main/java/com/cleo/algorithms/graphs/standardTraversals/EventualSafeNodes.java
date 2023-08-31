package com.cleo.algorithms.graphs.standardTraversals;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodes {
    /**
     *
     * @param graph In the given graph, find the nodes
     * @return from which all paths lead to terminal nodes, ie.
     * nodes from which there are no outgoing edges.
     */
    public List<Integer> eventualSafeNodes(int[][] graph){
        return new ArrayList<>();

    }

    public static void main(String[] args) {
        //Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
        //Output: [2,4,5,6]
        //Explanation: The given graph is shown above.
        //Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
        //Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
    }
}
