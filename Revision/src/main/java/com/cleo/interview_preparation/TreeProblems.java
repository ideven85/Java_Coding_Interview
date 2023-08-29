package com.cleo.interview_preparation;



import java.util.*;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode() {}
   TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
   }
 }
class BinaryTree{
    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public Pair(Pair<? extends K, ? extends V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public K getFirst() {
            return this.key;
        }

        public V getSecond() {
            return this.value;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            } else if (!(o instanceof Pair )) {
                return false;
            } else {
                boolean var10000;
                label43: {
                    label29: {
                        Pair<?, ?> oP = (Pair)o;
                        if (this.key == null) {
                            if (oP.key != null) {
                                break label29;
                            }
                        } else if (!this.key.equals(oP.key)) {
                            break label29;
                        }

                        if (this.value == null) {
                            if (oP.value == null) {
                                break label43;
                            }
                        } else if (this.value.equals(oP.value)) {
                            break label43;
                        }
                    }

                    var10000 = false;
                    return var10000;
                }

                var10000 = true;
                return var10000;
            }
        }

        public int hashCode() {
            int result = this.key == null ? 0 : this.key.hashCode();
            int h = this.value == null ? 0 : this.value.hashCode();
            result = 37 * result + h ^ h >>> 16;
            return result;
        }
    }

    public TreeNode insert(TreeNode root, int data){
        if(root==null)
            root = new TreeNode(data);
        else if(data < root.val)
            root.left = insert(root.left,data);
        else
            root.right = insert(root.right,data);
        return root;
    }

    List<List<Integer>> levelOrdered = new ArrayList<>();

    //Incorrect
    public List<List<Integer>> levelOrderV1(TreeNode root) {
        if(root==null)
            return levelOrdered;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            temp = new ArrayList<>();
            if(current.left!=null&&current.right!=null){
                temp.add(current.left.val);
                temp.add(current.right.val);
                levelOrdered.add(temp);
                queue.add(current.left);
                queue.add(current.right);

            }


            else if(current.left!=null) {
                temp.add(current.left.val);
                levelOrdered.add(temp);
                queue.add(current.left);
            }
            else if(current.right!=null) {
                temp.add(current.right.val);
                levelOrdered.add(temp);
                queue.add(current.right);
            }
        }
        return levelOrdered;


    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            //temp.add(current);
            if(current!=null) {
                temp.add(current.val);
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }else{
                List<Integer> current1 = new ArrayList<>(temp);
                answer.add(current1);
                temp.clear();
                if(!queue.isEmpty())
                    queue.offer(null);
            }
        }
        return answer;

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root==null)
            return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        boolean flag = false;
        int count = 1;
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();

            if(current!=null){
                // count+=1;
                temp.add(current.val);
                if(count==1) {
                    if (current.right != null)
                        queue.offer(current.right);
                    if (current.left != null)
                        queue.offer(current.left);
                    flag=true;
                    count+=1;
                }else if(count==2){
                    if (current.left != null)
                        queue.offer(current.left);
                    if (current.right != null)
                        queue.offer(current.right);
                    flag=false;
                    count-=1;

                }


            }else{
                List<Integer> c = new ArrayList<>(temp);
                answer.add(c);
                temp.clear();
                if(!queue.isEmpty())
                    queue.offer(null);
            }
        }
        return answer;

    }
    public int minDepth(TreeNode root) {
        if(root==null)
            return 1;
        return 1+Math.min(minDepth(root.left),minDepth(root.right));

    }

    //Minimum Time
    public int minDepthV2(TreeNode root){
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int count = 1;
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current!=null){
                if(current.left==null&&current.right==null)
                    return count;
                if(current.left!=null)
                    queue.offer(current.left);
                if(current.right!=null)
                    queue.offer(current.right);
            }else{
                count+=1;
                if(!queue.isEmpty())
                    queue.offer(null);
            }
        }
        return count;
    }

    //Minimum Memory Usage
    public int minDepthV3(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        else {
            stack.add(new Pair<>(root, 1));
        }

        int min_depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pollLast();
            root = current.getKey();
            int current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)) {
                min_depth = Math.min(min_depth, current_depth);
            }
            if (root.left != null) {
                stack.add(new Pair<>(root.left, current_depth + 1));
            }
            if (root.right != null) {
                stack.add(new Pair<>(root.right, current_depth + 1));
            }
        }
        return min_depth;
    }

    public boolean isSumTree(TreeNode root){
        if(root==null)
            return true;
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.add(new Pair<>(root, root.val));
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> current = stack.pollLast();
            root = current.getKey();
            int current_amount= current.getValue();
            if(root.left==null&&root.right==null){
                if(current_amount-root.val!=0)
                    return false;
            }
            if(root.left!=null){
                stack.add(new Pair<>(root.left,root.val-current_amount));
            }if(root.right!=null)
                stack.add(new Pair<>(root.right,root.val-current_amount));
        }
        return true;
    }
    public boolean isSumTreeV2(TreeNode root){
        if(root==null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int total= root.val;
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {

                if (current.left == null && current.right == null)
                    return total - current.val == 0;
                if (current.left != null) {
                    total-=current.left.val;
                    queue.offer(current.left);

                }
                if (current.right != null) {
                    total-=current.right.val;
                    queue.offer(current.right);
                }
            } else {


                if (!queue.isEmpty())
                    queue.offer(null);
            }
        }
        return true;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildBT(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }
    public static TreeNode buildBT(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;
        int data = preOrder[preStart];
        TreeNode cur = new TreeNode(data); int offset = inStart;
        for(; offset < inEnd; offset++){ if(inOrder[offset] == data)
            break; }
        cur.left = buildBT(preOrder, preStart + 1, preStart + offset - inStart, inOrder, inStart, offset - 1);
        cur.right = buildBT(preOrder, preStart + offset - inStart + 1, preEnd, inOrder, offset + 1, inEnd);
        return cur;
    }
    public boolean hasPathSumV2(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum_so_far=0;
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            sum_so_far+=current.val;
            //  System.out.println(sum_so_far);
            if(current.left==null&&current.right==null) {
                System.out.println(sum_so_far);
                if (sum_so_far == targetSum)
                    return true;

            }

            if(current.left!=null)
                queue.offer(current.left);
            if(current.right!=null)
                queue.offer(current.right);
        }
        if(sum_so_far==targetSum)
            return true;
        return false;

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        if(root.left==null&&root.right==null&&root.val==targetSum)
            return true;
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }


    boolean isBST(TreeNode root) {
        // code here.
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        return BST(root,min,max);

    }
    public int height(TreeNode root){
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    private static boolean BST(TreeNode root, int min, int max) {
        if (root==null){
            return true;
        }
        if(root.val>=Integer.MAX_VALUE)
            return false;
        if(root.val<=Integer.MIN_VALUE)
            return false;
        return root.val>min && root.val<max && BST(root.left,min,root.val) && BST(root.right,root.val,max);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)
            return  0;
        int left = height(root.left);
        if(left>k)
            return kthSmallest(root.left,k);
        else if(left<k)
            return kthSmallest(root.right,k-left -1);
        else
            return root.val;



    }

}
public class TreeProblems {
    private static class Pair{
        TreeNode node; int data;

        public Pair(TreeNode node, int data) {
            this.node = node;
            this.data = data;
        }
    }
    public TreeNode insert(TreeNode root, int val){
        if(root==null)
            root = new TreeNode(val);
        else if(val < root.val)
            root.left = insert(root.left,val);
        else if(val > root.val)
            root.right = insert(root.right,val);
        return root;
    }

    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
    public static void topView(TreeNode root) {
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> current = new LinkedList<>();
        current.add(new Pair(root,0));
        map.put(0,root.val);
        while(!current.isEmpty()) {
            Pair u = current.poll();
            TreeNode node = u.node;
            int height = u.data;
            if(map.get(height)==null)
                map.put(height, node.val);
            if(node.left!=null){
                current.add(new Pair(node.left,height-1));

            }
            if(node.right!=null)
                current.add(new Pair(node.right,height+1));
        }
        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            System.out.print(m.getValue() + " ");
        }
        System.out.println();
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> verticalOrderTraversal = new ArrayList<>();
        if(root==null)
            return verticalOrderTraversal;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> curr = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current!=null){

                if(current.left!=null)
                    queue.offer(current.left);

                if(current.right!=null)
                    queue.offer(current.right);
                curr.add(current.val);
            }else{
                List<Integer> c_curr = new ArrayList<>(curr);
                verticalOrderTraversal.add(c_curr);
                curr.clear();
                if(!queue.isEmpty())
                    queue.offer(null);

            }
        }

        return verticalOrderTraversal;


    }


    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return false;
        if(root.left!=null&&root.right!=null)
            if(root.left.val==root.right.val)
                return true;
        return isSymmetric(root.left)==isSymmetric(root.right);
        //return false;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left!=null) {
                if(current.left.left==null&&current.left.right==null)
                    sum += current.left.val;
                queue.add(current.left);
            }
            if(current.right!=null)
                queue.add(current.right);

        }
        return sum;

    }

    public static void main(String[] args) {

        TreeProblems treeProblems = new TreeProblems();
        TreeNode root1 = new TreeNode();
        treeProblems.insert(root1,10);
        treeProblems.insert(root1,5);
        treeProblems.insert(root1,4);
        treeProblems.insert(root1,7);
        treeProblems.insert(root1,15);
        treeProblems.insert(root1,20);
        treeProblems.insert(root1,14);
        System.out.println(treeProblems.levelOrder(root1));
        topView(root1);
        System.out.println(treeProblems.sumOfLeftLeaves(root1));
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(3);
        tree.insert(root,2);
        tree.insert(root,9);
        //   tree.insert(root,20);
        tree.insert(root,15);
        tree.insert(root,17);
        // tree.insert(root,16);
        //   tree.insert(root,1);
        // tree.insert(root,0);
        System.out.println(tree.levelOrder(root));
        System.out.println(tree.zigzagLevelOrder(root));
        System.out.println(tree.minDepth(root));
        System.out.println(System.currentTimeMillis());
        System.out.println(tree.minDepthV2(root));
        System.out.println(System.currentTimeMillis());
        System.out.println(tree.minDepthV3(root));
        System.out.println(System.currentTimeMillis());
        System.out.println(tree.hasPathSumV2(root,44));
        System.out.println(tree.hasPathSum(root,44));
        System.out.println(tree.isSumTree(root));
        System.out.println(tree.kthSmallest(root,3));
    }
}
