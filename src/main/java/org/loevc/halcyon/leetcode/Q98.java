package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q98 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            int temp = list.get(0);
            list.remove(0);
            for (Integer a : list) {
                if (a == null)
                    continue;
                if (a <= temp)
                    return false;
                else {
                    temp = a;
                }

            }
            return true;
        }

        private Integer inOrder(TreeNode root, List<Integer> list) {
            if (root == null)
                return null;
            Integer left = inOrder(root.left, list);
            if (left != null)
                list.add(left);
            list.add(root.val);
            Integer right = inOrder(root.right, list);
            if (right != null)
                list.add(right);
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        // 这么做，太慢了，太蠢了，应该利用List<Integer> 转为二叉树
        new Q98().new Solution().isValidBST(root);
    }
}
