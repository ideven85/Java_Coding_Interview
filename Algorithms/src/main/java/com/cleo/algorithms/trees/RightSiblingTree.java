package com.cleo.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSiblingTree {
    private static class Edge{
        TreeNode node1,node2;
        int distance;

    }
    public static TreeNode rightSiblingTree(TreeNode root) {
        // Write your code here.
        if(root==null)
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Edge> edgeListAtEachLevel = new ArrayList<>();
        List<List<Integer>> vals = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            temp.add(current.val);


        }

        return root;
    }
}
