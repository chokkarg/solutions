package org.cg.leetcode.easy.pathsum2;

import java.util.Stack;

public class CheckPathSumOfBinaryTreeFunction {
    // Recursive way to do it, O(n) when n is the number of node
    public boolean hasPathSum(TreeNode root, int sum) {
        // Base case, we know there are no more child if current is null
        if (root == null) {
            return false;
        } else {
            // if it reach leaf
            // sum - root.val could also be sum == root.val
            if (root.left == null && root.right == null && sum - root.val == 0) {
                return true;
            }

            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    // Using two stack iterative way, slower than recursive, but easy to understand
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> node_stack = new Stack();

        Stack<Integer> sum_stack = new Stack();

        node_stack.add(root);
        sum_stack.add(sum - root.val);

        while (!node_stack.isEmpty()) {
            TreeNode current = node_stack.pop();
            int current_sum = sum_stack.pop();

            // If it is a leaf
            // if sum path equal to zero
            if (current.left == null && current.right == null && current_sum == 0) {
                return true;
            }

            // Add left children
            if (current.left != null) {
                node_stack.add(current.left);
                sum_stack.add(current_sum - current.left.val);
            }

            // Add right children
            if (current.right != null) {
                node_stack.add(current.right);
                sum_stack.add(current_sum - current.right.val);
            }
        }

        return false;
    }
}
