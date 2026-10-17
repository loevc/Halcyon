package org.loevc.halcyon.leetcode;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public void printNodeList(){
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = this;
        while (cur != null){
            stringBuilder.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        stringBuilder.append("\b\b\b\b");
        System.out.println(stringBuilder.toString());
    }

}