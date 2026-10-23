package org.loevc.halcyon.leetcode;

public class Q108 {

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
        public TreeNode sortedArrayToBST(int[] nums) {
            return combine(nums, 0, nums.length - 1);
        }

        private TreeNode combine(int[] nums, int left, int right) {
            int mid = left + (right - left) / 2;
            if (right - left == 0) {
                return new TreeNode(nums[left]);
            }
            if (right - left == 1) {
                TreeNode root = new TreeNode(nums[left]);
                root.right = new TreeNode(nums[right]);
                return root;

            }
            if (right - left == 2) {
                TreeNode root = new TreeNode(nums[mid]);
                root.left = new TreeNode(nums[left]);
                root.right = new TreeNode(nums[right]);
                return root;
            }

            TreeNode root = new TreeNode(nums[mid]);
            root.left = combine(nums, left, mid - 1);
            root.right = combine(nums, mid + 1, right);
            return root;
        }
    }

     public static void main(String[] args) {
         TreeNode treeNode = new Q108().new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
         treeNode.printInOrder();
     }
}
