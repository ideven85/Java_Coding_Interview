package com.cleo.interview_preparation;

import java.util.*;
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class UndirectedGraphs {
    private List<List<Integer>> adj = new ArrayList<>();

    public void addEdge(int source, int destination){
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination)
            return true;
        for (int i = 0; i <n ; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] vertices:edges){

            addEdge(vertices[0],vertices[1]);
        }

        boolean[] visited = new boolean[n];

        return dfsUtil(source,destination,visited);

    }
    public boolean dfsUtil(int source, int destination, boolean[] visited){
        visited[source]=true;
        for(var v:adj.get(source)){
            if(v==destination)
                return true;
            if(!visited[v]){
                return dfsUtil(v,destination,visited);
            }
        }
        return false;
    }
    public boolean validPathV2(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjacency_list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency_list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        boolean seen[] = new boolean[n];
        Arrays.fill(seen, false);

        while (!stack.isEmpty()) {
            // Get the current node.
            int node = stack.pop();

            // Check if we have reached the target node.
            if (node == end) {
                return true;
            }

            // Check if we've already visited this node.
            if (seen[node]) {
                continue;
            }
            seen[node] = true;

            // Add all neighbors to the stack.
            for (int neighbor : adjacency_list.get(node)) {
                stack.push(neighbor);
            }
        }

        return false;
    }

    public boolean validPathBFS(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(var row: edges){
            adj.get(row[0]).add(row[1]);
            adj.get(row[1]).add(row[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current==destination)
                return true;
            if(visited[current])
                continue;
            visited[current]=true;
            for(int vertex:adj.get(current)){
                if(!visited[vertex]){
                    visited[vertex]=true;
                    queue.add(vertex);
                }
            }

        }
        return false;


    }



    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        int n = graph.length;
        List<Integer> current = new ArrayList<>();
        boolean[] seen = new boolean[n];
        int source = 0, destination=n-1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(curr!=destination){
                if(seen[curr])
                    continue;
                current.add(curr);
                seen[curr]=true;

                for(int vertex:graph[curr]){
                    if(!seen[vertex]){

                        queue.add(vertex);
                    }
                }


            }else {
                current.add(destination);
                List<Integer> c_curr = new ArrayList<>(current);
                paths.add(new ArrayList<>(c_curr));
                current.clear();
                current.add(source);
            }


        }
        return paths;
    }

    public List<List<Integer>> allPathsSourceTargetV2(int[][] graph) {
            List<List<Integer>> paths = new ArrayList<>();
            if (graph == null || graph.length == 0) {
                return paths;
            }

            Queue<List<Integer>> queue = new LinkedList<>();
            List<Integer> path = new ArrayList<>();
            path.add(0);
            queue.add(path);

            while (!queue.isEmpty()) {
                List<Integer> currentPath = queue.poll();
                int node = currentPath.get(currentPath.size() - 1);
                for (int nextNode: graph[node]) {
                    List<Integer> tmpPath = new ArrayList<>(currentPath);
                    tmpPath.add(nextNode);
                    if (nextNode == graph.length - 1) {
                        paths.add(new ArrayList<>(tmpPath));
                    } else {
                        queue.add(new ArrayList<>(tmpPath));
                    }
                }
            }
            return paths;
        }

    public Node cloneGraph(Node node) {

        return node;
    }

    public static void main(String[] args) {
        int n = 6, source = 0, destination = 5;
        int[][] edges = new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}};
        UndirectedGraphs ug = new UndirectedGraphs();
        System.out.println(ug.validPathBFS(n,edges,source,destination));
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(ug.allPathsSourceTarget(graph));
    }

}
