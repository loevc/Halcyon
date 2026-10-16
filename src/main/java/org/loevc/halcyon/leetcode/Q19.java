package org.loevc.halcyon.leetcode;

public class Q19 {

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

    /**
     * 还有更优解法，为什么本次解法要单独判断头节点呢?
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode slow = head;
            ListNode fast = head;
            for (int i = 0; i < n; ++i) {
                fast = fast.next;
            }
            if (fast == null) {
                return head.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }

     public static void main(String[] args) {
//        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode listNode = new ListNode(1, new ListNode(2));
        ListNode listNode = new ListNode(1);
        listNode = new Q19().new Solution().removeNthFromEnd(listNode, 1);


        listNode.printNodeList();
     }
}
