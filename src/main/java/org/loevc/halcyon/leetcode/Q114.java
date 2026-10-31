package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q114 {

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
        public void flatten(TreeNode root) {
            List<TreeNode> list = new ArrayList<>();
            dfs(root, list);
            for (int i = 0; i < list.size() - 1; ++i) {
                list.get(i).left = null;
                list.get(i).right = list.get(i + 1);
            }
        }

        private List<TreeNode> dfs(TreeNode root, List<TreeNode> list) {
            if (root == null)
                return list;
            list.add(root);
            dfs(root.left, list);
            dfs(root.right, list);
            return list;

        }
    }

     public static void main(String[] args) {
     }
}
