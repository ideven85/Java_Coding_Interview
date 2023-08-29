package com.cleo.algorithms.hashing;


public class MyHashMapUsingBST implements MyHashMap {
    //Map<Integer,Integer>,map.put(1,1)
    TreeNode root,current;
    @Override
    public void put(int value) {
        current=insertHelper(root,value);
        /*


         */


    }

    public TreeNode insertHelper(TreeNode root, int value){
        if(root==null)
            root = new TreeNode(value);

        int leftHeight=0,rightHeight=0;
       /* if(root.left!=null)
            leftHeight=root.height(root.left);
        if(root.right!=null)

            rightHeight=root.height(root.right);
        if(leftHeight>rightHeight)
            root.right=insertHelper(root.right,value);
        else if(leftHeight<=rightHeight)
            root.left=insertHelper(root.left,value);

        */
        if(value< root.val)
            root.left=insertHelper(root.left,value);
        else if(value>= root.val)
            root.right=insertHelper(root.right,value);

        //To make it height balanced, we will have to choose some
        // other node as our root preferably the mid point in sorted order
        assert root.isHeightBalanced(root);


        return root;
    }


    @Override
    public int getKey(int value) {
        return 0;
    }

    @Override
    public void deleteKey(int key) {

    }
}
