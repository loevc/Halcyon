package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q230 {

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            return list.get(k - 1);
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
        TreeNode root = TreeNode.buildTreeByLevel(new Integer[]{3, 1, 4, null, 2});
        System.out.println(new Q230().new Solution().kthSmallest(root, 1));
    }
}
