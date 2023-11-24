package com.cleo.dummy;

public class Main {

    public TreeNode insert(TreeNode root, int val){
        if(root==null)
            root = new TreeNode(val);
        else if(val== root.val)
            root.right=insert(root.right,val);
       else if(val< root.val)
            root.left=insert(root.left,val);
        else if(val> root.val)
            root.right=insert(root.right,val);
        return root;
    }
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
       /* System.out.println();*/
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10),current=null;
        Main main = new Main();
        main.insert(root,10);
        main.insert(root,5);
        main.insert(root,12);
        main.insert(root,13);
        main.insert(root,2);
        main.inOrder(root);
        System.out.println();


        System.out.println("Hello world!");
    }
}