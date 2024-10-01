package com.cleo.graphs;

import java.io.IOException;
import java.util.*;

public class Get_Path_DFS {

    private static final Map<Integer, List<Integer>> graph = new HashMap<>();

   // private static List<Integer> path = new ArrayList<>();
    public static List<Integer>  dfsUtil(int source, int destination,boolean[] visited,List<Integer> temp){
        if(source==destination){
            System.out.println(temp);
           List<Integer> result=new ArrayList<>();
            result.add(source);
            return result;
        }

        if(!visited[source]){
            temp.add(source);
            visited[source]=true;
            List<Integer> connections = graph.get(source);
            if(connections!=null){
                for(int conn:connections){
                     dfsUtil(conn,destination,visited,temp);


                }
            }
        }
        return temp;


    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int E = in.nextInt();
        for (int i = 0; i < N; i++) {
            graph.put(i,new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);

        }
        int source = in.nextInt();
        int destination = in.nextInt();
        boolean[] visited = new boolean[N];
        List<Integer> result= new ArrayList<>();
       result= dfsUtil(source,destination,visited,result);

        if(!result.isEmpty()){
            for(int r:result){
                System.out.print(r+ " ");
            }
            System.out.println();
        }


    }
}
