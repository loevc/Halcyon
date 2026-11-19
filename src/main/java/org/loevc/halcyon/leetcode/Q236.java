package org.loevc.halcyon.leetcode;

public class Q236 {

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return null;
            if (p == root || q == root)
                return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null)
                return root;

            return left != null ? left : right;

        }
    }

     public static void main(String[] args) {
     }
}
