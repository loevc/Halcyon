package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q437 {

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

        private int res = 0;

        public int pathSum(TreeNode root, int targetSum) {
            Map<Long, Integer> map = new HashMap<>();
            map.put(0L, 1);
            dfs(root, 0, map, targetSum);
            return res;
        }

        private void dfs(TreeNode root, long sum, Map<Long, Integer> map, int targetSum) {
            if (root == null)
                return;
            sum += root.val;
            int cnt = map.getOrDefault(sum, 0);
            res += map.getOrDefault(sum - targetSum, 0);
            map.put(sum, cnt + 1);
            dfs(root.left, sum, map, targetSum);
            dfs(root.right, sum, map, targetSum);

            map.put(sum, cnt);
        }
    }

     public static void main(String[] args) {
     }
}
