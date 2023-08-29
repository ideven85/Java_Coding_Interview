package com.cleo.algorithms.trees;

public class NodeDepthSums {
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int depth(BinaryTree root){
        if(root==null)
            return 0;
        return 1+Math.max(depth(root.left),depth(root.right));
    }
    public static int allKindsOfNodeDepths(BinaryTree root) {
        // Write your code here.

        return -1;
    }

}
