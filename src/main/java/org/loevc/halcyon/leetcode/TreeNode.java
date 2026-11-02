package org.loevc.halcyon.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void printInOrder(){
        StringBuilder stringBuilder = new StringBuilder();
        inOrder(this, stringBuilder);
        stringBuilder.append("\b\b");
        System.out.println(stringBuilder);
    }

    public void printLevelOrder(){
        StringBuilder stringBuilder = new StringBuilder();
        levelOrder(this, stringBuilder);
        stringBuilder.append("\b\b");
        System.out.println(stringBuilder);
    }

    private void inOrder(TreeNode root, StringBuilder stringBuilder){
        if (root == null) return ;
        inOrder(root.left, stringBuilder);
        stringBuilder.append(root.val).append("->");
        inOrder(root.right, stringBuilder);
    }


    private void levelOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasNextLevel = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) {
                    sb.append("null->");
                    continue;
                }

                sb.append(node.val).append("->");

                queue.offer(node.left);
                queue.offer(node.right);

                if (node.left != null || node.right != null) {
                    hasNextLevel = true;
                }
            }

            sb.append("\n");

            // 当前层没有任何非空节点可以继续向下扩展
            if (!hasNextLevel) {
                break;
            }
        }
    }

    public static TreeNode buildTreeByLevel(Integer[] nums) {
        if (nums == null || nums.length == 0 || nums[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty() && index < nums.length) {
            TreeNode current = queue.poll();

            // 构建左子节点
            if (index < nums.length && nums[index] != null) {
                current.left = new TreeNode(nums[index]);
                queue.offer(current.left);
            }
            index++;

            // 构建右子节点
            if (index < nums.length && nums[index] != null) {
                current.right = new TreeNode(nums[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

}
