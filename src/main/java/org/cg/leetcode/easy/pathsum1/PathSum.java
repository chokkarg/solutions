package org.cg.leetcode.easy.pathsum1;

import java.util.Stack;

public class PathSum {
    public static void main(String[] args) {

        boolean isPathSum = hasPathSum(new TreeNode(1) , 25);

        System.out.println(isPathSum);
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        // iteration method
        if (root == null) {return false;}
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        path.push(root);
        sub.push(root.val);
        while (!path.isEmpty()) {
            TreeNode temp = path.pop();
            int tempVal = sub.pop();
            if (temp.left == null && temp.right == null) {if (tempVal == sum) return true;}
            else {
                if (temp.left != null) {
                    path.push(temp.left);
                    sub.push(temp.left.val + tempVal);
                }
                if (temp.right != null) {
                    path.push(temp.right);
                    sub.push(temp.right.val + tempVal);
                }
            }
        }
        return false;
    }


}