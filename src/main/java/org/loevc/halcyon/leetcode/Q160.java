package org.loevc.halcyon.leetcode;

public class Q160 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pA = new ListNode(-1);
            ListNode pB = new ListNode(-1);
            pA.next = headA;
            pB.next = headB;

            while (true) {
                if (pA.next == null && pB.next == null)
                    return null;
                if (pA.next == pB.next)
                    return pA.next;
                if (pA.next == null) {
                    pA.next = headB;
                } else {
                    pA.next = pA.next.next;
                }
                if (pB.next == null) {
                    pB.next = headA;
                } else {
                    pB.next = pB.next.next;
                }

            }

        }
    }

     public static void main(String[] args) {
         ListNode node5 = new Q160().new ListNode(5);
         ListNode node4 = new Q160().new ListNode(4);
         ListNode node8 = new Q160().new ListNode(8);
         node4.next = node5;
         node8.next = node4;

         ListNode nodeA4 = new Q160().new ListNode(4);
         ListNode nodeA1 = new Q160().new ListNode(1);
         nodeA4.next = nodeA1;
         nodeA1.next = node8;

         ListNode nodeB5 = new Q160().new ListNode(5);
         ListNode nodeB6 = new Q160().new ListNode(6);
         ListNode nodeB1 = new Q160().new ListNode(1);
         nodeB5.next = nodeB6;
         nodeB6.next = nodeB1;
         nodeB1.next = node8;

         System.out.println(new Q160().new Solution().getIntersectionNode(nodeA4, nodeB5).val);
     }
}
