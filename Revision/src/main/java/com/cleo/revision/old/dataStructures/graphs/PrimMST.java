package com.cleo.revision.old.dataStructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimMST {

    public static int primsAlgorithmForMST(int[][] graph, int V){
        boolean[] inMST = new boolean[V];
        int output=0;
        int[] keySet = new int[V];
        Arrays.fill(keySet,Integer.MAX_VALUE);
        keySet[0]=0;
        List<Integer> mst = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            int u=-1;
            for (int j = 0; j < V; j++) {
                if(!inMST[j]&&(u==-1||keySet[j]<keySet[u]))
                    u=j;
            }
            mst.add(u);
            inMST[u]=true;
            output+=keySet[u];
            for (int v = 0; v < V; v++) {
                if(!inMST[v] &&graph[u][v]!=0)
                    keySet[v]=Math.min(keySet[v],graph[u][v]);
            }
        }
        System.out.println(mst);
        return output;
    }

    public static void main(String[] args) {
        int[][] graph={{0,5,8,0},
                {5,0,10,15},
                {8,10,0,20},
                {0,15,20,0}};
        System.out.println(primsAlgorithmForMST(graph,4));
    }

}
