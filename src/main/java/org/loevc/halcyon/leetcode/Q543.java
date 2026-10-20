package org.loevc.halcyon.leetcode;

public class Q543 {

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

        private int max;

        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return max;
        }

        /**
         * 这个题目还不是很明白，似懂非懂。
         * @param root
         * @return
         */
        private int depth(TreeNode root) {
            if (root == null)
                return 0;
            int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);
            // 当前node下，直径最大值和全局最大值 比较大小，更新全局最值
            max = Math.max(max, leftDepth + rightDepth);
            // 不再返回当前节点的直径，而是返回当前节点的深度，深度是左子树和右子树的最大深度加1
            // 为什么2022版本的idea ultimate 会自动提示注释呢？ 之前没注意到有呢？
            return Math.max(leftDepth, rightDepth) + 1;
        }

    }

     public static void main(String[] args) {
     }
}
