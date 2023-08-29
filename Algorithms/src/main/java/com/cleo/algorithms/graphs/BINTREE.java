package com.cleo.algorithms.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BINTREE {

    static class TreeNode{
        int val;
        TreeNode left,right;

        public TreeNode(int val) {
            this.val = val;
            this.left=null;
            this.right=null;
        }
    }
    public static TreeNode insert(TreeNode root, int val){

        if(root==null)
            root = new TreeNode(val);
        else if(val%2==0)
            root.left=insert(root.left,val);
        else
            root.right=insert(root.right,val);
        return root;


    }
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        int N = in.nextInt();
        TreeNode root = new TreeNode(1);
        while(N-->0){
            int first= in.nextInt();
            int second= in.nextInt();
            int max = Math.max(first,second);
            for (int i = 1; i <=max ; i++) {
                root=insert(root,2*i);
                root=insert(root,2*i+1);
            }


        }

    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
