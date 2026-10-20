package org.loevc.halcyon.leetcode;

public class Q101 {

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
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            return isSymmetricSubTree(root.left, root.right);
        }

        // 为什么要用这个递归呢？ 因为我们要比较的是两棵子树是否对称，而不是单个节点。通过递归地比较左子树的左孩子和右子树的右孩子，以及左子树的右孩子和右子树的左孩子，我们可以确保整个结构是对称的。
        // 所以不能使用isSymmetric(root)这种单节点比较，而是要使用isSymmetricSubTree(left, right)这种对子树的比较。
        private boolean isSymmetricSubTree(TreeNode left, TreeNode right) {
            if (left == null && right == null)
                return true;
            else if (left != null && right != null) {
                if (left.val == right.val) {
                    return isSymmetricSubTree(left.left, right.right) && isSymmetricSubTree(left.right, right.left);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

     public static void main(String[] args) {
     }
}
