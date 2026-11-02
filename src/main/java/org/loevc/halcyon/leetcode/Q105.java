package org.loevc.halcyon.leetcode;

public class Q105 {

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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0)
                return null;
            int val = preorder[0];
            int idx = 0;
            for (int i : inorder) {
                if (i == val)
                    break;
                ++idx;
            }
            int inLength = inorder.length;
            int leftCnt = idx;
            int rightCnt = inLength -1 - idx;
            TreeNode root = new TreeNode(val);

            // solve 左子树
            int[] leftPreorder = new int[leftCnt];
            int[] leftInorder = new int[leftCnt];
            for (int i = 0; i < leftCnt; ++i) {
                leftPreorder[i] = preorder[i + 1];
                leftInorder[i] = inorder[idx - leftCnt + i];
            }
            root.left = buildTree(leftPreorder, leftInorder);

            // solve 右子树
            int[] rightPreorder = new int[rightCnt];
            int[] rightInorder = new int[rightCnt];
            for (int i = 0; i < rightCnt; ++i) {
                rightPreorder[i] = preorder[i + 1 + leftCnt];
                rightInorder[i] = inorder[idx + 1 + i];
            }
            root.right = buildTree(rightPreorder, rightInorder);

            return root;
        }

    }

     public static void main(String[] args) {
         TreeNode treeNode = new Q105().new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
         treeNode.printLevelOrder();
     }
}
