package org.loevc.halcyon.leetcode;

public class Q104 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        int depth = 0;

        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            depth = Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
            return depth;
        }
    }

     public static void main(String[] args) {
     }
}
