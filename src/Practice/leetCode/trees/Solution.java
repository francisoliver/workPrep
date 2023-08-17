package Practice.leetCode.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

}
