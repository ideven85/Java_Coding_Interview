package com.cleo.revision.old.interview_preparation;

public class UnionFind {

    private int[] root;
    private int[] rank;



    public void init(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            this.root[i]=i;
        }
    }

    public int find(int x){
        if(root[x]==x)
            return x;
        else return root[x]=find(root[x]);
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!=rootY){
            root[rootY]=rootX;
        }
    }
    public boolean connected(int x, int y){
        return find(x)==find(y);
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        init(n);
        for(var row:edges){
            union(row[0],row[1]);
        }
        return connected(source,destination);
    }

    public static void main(String[] args) {
        int n = 6, source = 3, destination = 2;int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        UnionFind uf = new UnionFind();
        int n1 = 3, source1 = 1, destination1 = 2;int[][] edges1 = {{0,1},{0,2}};

        System.out.println(uf.validPath(n,edges,source,destination));
        UnionFind uf1 = new UnionFind();
        System.out.println(uf1.validPath(n1,edges1,source1,destination1));
    }
}
