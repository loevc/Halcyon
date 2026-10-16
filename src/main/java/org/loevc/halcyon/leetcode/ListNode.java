package org.loevc.halcyon.leetcode;

public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void printNodeList(ListNode listNode){
        StringBuilder stringBuilder = new StringBuilder();
        while (listNode != null){
            stringBuilder.append(listNode.val).append(" -> ");
            listNode = listNode.next;
        }
        stringBuilder.append("\b\b\b\b");
        System.out.println(stringBuilder.toString());
    }


    public void printNodeList(){
        StringBuilder stringBuilder = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            stringBuilder.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        stringBuilder.append("\b\b\b\b");
        System.out.println(stringBuilder.toString());
    }

}
