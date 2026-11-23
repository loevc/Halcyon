package org.loevc.halcyon.leetcode;

public class Q124 {

    class Solution {
        private int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode root) {
            if (root == null)
                return 0;
            int sumL = dfs(root.left);
            int sumR = dfs(root.right);
            ans = Math.max(ans, root.val + sumL + sumR);
            return Math.max(Math.max(sumL, sumR) + root.val, 0);
        }
    }

     public static void main(String[] args) {
     }
}
