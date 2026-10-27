package org.loevc.halcyon.leetcode;

public class Q206 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode pre = null;
            ListNode cur = head;
            while(cur != null){
                ListNode node = cur;
                cur = cur.next;
                node.next = pre;
                pre = node;
            }
            return pre;
        }
    }

     public static void main(String[] args) {
     }
}
