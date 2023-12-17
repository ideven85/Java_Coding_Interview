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
    public long solve(long a, long b) {
        // code here
        long max = Math.max(a,b);
        long answer=Long.MAX_VALUE;
        for (long i = 1; i <= max; i++) {
            long x=a&i;
            long y=b&i;
            answer=Math.min(x+y,answer);
          //  System.out.print(answer + " ");
        }
        return answer;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10),current=null;
        Main main = new Main();
        System.out.println(main.solve(4,8));
        int a = 8&1;
        System.out.println(a);
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