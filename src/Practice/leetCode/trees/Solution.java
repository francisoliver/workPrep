package Practice.leetCode.trees;

import java.util.*;

public class Solution {
    public void sayHello() {
        System.out.println("Hello from tree solution!");
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);
        return  root;
    }

    TreeNode invertTreeLoop(TreeNode root) {
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();

            // Swap nodes
            final TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // Add left and right of this node to the queue
            if (node.left != null) queue.add(node.left);

            if (node.right != null) queue.add(node.right);
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        if(root ==null) return 0;
        int count = 0;
        LinkedList<TreeNode> nodes = new LinkedList<>();

        while (!nodes.isEmpty()) {
            count++;
            int size = nodes.size();
            for(int i=0; i < size; i++) {
                TreeNode n = nodes.poll();
                if(n.left != null) nodes.add(n.left);
                if(n.right != null) nodes.add(n.right);
            }

        }
        return count;
    }
    int maxTreeNode = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxTreeNode;
    }

    private int dfs(TreeNode root) {

        int left =0, right = 0;

        if(root.right != null) right = dfs(root.right);
        if(root.left != null) left = dfs(root.left);

        maxTreeNode = Math.max(maxTreeNode, left + right);
        return Math.max(left, right) +1;

    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root){

        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == -1 || right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {

            TreeNode node1 = queue.poll(), node2 = queue.poll();

            if( node1 == null && node2 == null) {
                continue;
            } else if(
                    node1 == null || node2 == null || node1.val != node2.val
            )  {
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.left);
            queue.add(node1.right);
            queue.add(node2.right);
        }

        return true;

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if(node == null) {
                return false;
            }

            if(node.val == subRoot.val && isSameTree(node, subRoot)) {
                return true;
            }

            if(node.left != null ) queue.add(node.left);
            if(node.right != null ) queue.add(node.right);

        }
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val > root.val  && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            List<Integer> values = new ArrayList<>();

            int size = queue.size();

            while(size > 0) {

                TreeNode node = queue.poll();
                values.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

                size--;
            }

            result.add(values);

        }

        return result;

    }

    void helper(TreeNode treeNode, List<Integer> inOrderList) {
        if (treeNode == null)
            return;

        helper(treeNode.left, inOrderList);
        inOrderList.add(treeNode.val);
        helper(treeNode.right, inOrderList);
    }

    public boolean isValidBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        helper(root, list);

        int pre = list.get(0);
        for(int i = 1; i<list.size(); i++) {
            if(pre>=list.get(i)) return false;
        }
        return true;

    }

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        helper(root, list);

        return list.get(k - 1);

    }

}
