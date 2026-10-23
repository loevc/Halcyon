package org.loevc.halcyon.leetcode;

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

    private void inOrder(TreeNode root, StringBuilder stringBuilder){
        if (root == null) return ;
        inOrder(root.left, stringBuilder);
        stringBuilder.append(root.val).append("->");
        inOrder(root.right, stringBuilder);
    }

}
