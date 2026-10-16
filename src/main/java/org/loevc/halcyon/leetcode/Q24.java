package org.loevc.halcyon.leetcode;

public class Q24 {

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
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode slow = head;
            ListNode fast = head;
            fast = fast.next;

            slow.next = fast.next;
            fast.next = slow;
            slow.next = swapPairs(slow.next);
            return fast;
        }
    }

     public static void main(String[] args) {
     }
}
