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
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 为什么简单题，做着这么费劲！
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = null;
            ListNode cur = new ListNode(0);
            cur.next = head;
            while (cur.next != null) {
                cur.next = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = cur.next;
            }
            return dummy.next;
        }
    }

     public static void main(String[] args) {
     }
}
