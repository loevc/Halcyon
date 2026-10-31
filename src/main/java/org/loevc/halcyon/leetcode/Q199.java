package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199 {

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
        public List<Integer> rightSideView(TreeNode root) {
            // bfs  取每层最右节点
            if (root == null)
                return new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            List<List<Integer>> allNodes = bfs(root);
            for (List<Integer> list : allNodes) {
                if (list.size() == 0)
                    break;
                res.add(list.get(list.size() - 1));
            }
            return res;
        }

        private List<List<Integer>> bfs(TreeNode root) {
            // 临时每层节点
            Queue<TreeNode> queue = new LinkedList<>();
            // 完整树节点
            List<List<Integer>> res = new ArrayList<>();
            if (root == null)
                return res;
            queue.offer(root);
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(list);

            while (!queue.isEmpty()) {
                List<TreeNode> nodes = new ArrayList<>();
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    nodes.add(node.left);
                    nodes.add(node.right);
                }
                List<Integer> levelList = new ArrayList<>();
                for (TreeNode node : nodes) {
                    if (node == null)
                        continue;
                    queue.offer(node);
                    levelList.add(node.val);
                }
                res.add(levelList);
            }
            return res;
        }
    }

     public static void main(String[] args) {
     }
}
