package com.cleo.graphs;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HasPath {

    static class UnionFind{
        private int[] root;

        public UnionFind(int V) {
            root= IntStream.rangeClosed(0,V).toArray();
        }

        public int find(int vertex){
            if(root[vertex]!=vertex)
                root[vertex]=find(root[vertex]);
            return root[vertex];
        }
        public void union(int v1, int v2){
            int rootV1=find(v1);
            int rootV2=find(v2);
            if(rootV1!=rootV2)
                root[rootV1]=rootV2;
        }
        public boolean connected(int a, int b){
            return find(a)==find(b);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        UnionFind uf = new UnionFind(n);
        if (n == 0) return;
        for (int i = 0; i < e; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            uf.union(v1,v2);

        }
        int v1 = scanner.nextInt();
        int v2= scanner.nextInt();
        System.out.println(uf.connected(v1,v2));

    }
}