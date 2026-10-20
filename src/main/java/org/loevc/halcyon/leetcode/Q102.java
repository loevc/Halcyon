package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q102 {

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null)
                return res;
            res.add(new ArrayList() {
                {
                    add(root.val);
                }
            });
            List<TreeNode> nodes = level(Collections.singletonList(root));
            while (!nodes.isEmpty()) {
                res.add(nodes.stream().map(node -> node.val).collect(Collectors.toList()));
                nodes = level(nodes);
            }
            return res;
        }

        private List<TreeNode> level(List<TreeNode> nodes) {
            List<TreeNode> res = new ArrayList<>();
            for (TreeNode node : nodes) {
                if (node.left != null)
                    res.add(node.left);
                if (node.right != null)
                    res.add(node.right);
            }
            return res;
        }
    }

     public static void main(String[] args) {
     }
}
