package org.loevc.halcyon.leetcode;

public class Q2 {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();
            int carry = 0;
            int sum = 0;
            ListNode dummy = res;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    sum = l2.val + carry;
                    l2 = l2.next;
                }

                else if (l2 == null) {
                    sum = l1.val + carry;
                    l1 = l1.next;
                }

                else {
                    sum = (l1.val + l2.val + carry);
                    l1 = l1.next;
                    l2 = l2.next;
                }

                carry = sum / 10;
                res.next = new ListNode(sum % 10);
                res = res.next;
            }
            if (carry != 0){
                res.next = new ListNode(carry);
            }
            return dummy.next;
        }
    }

     public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Solution solution = new Q2().new Solution();
         ListNode listNode = solution.addTwoNumbers(l1, l2);
         ListNode.printNodeList(listNode);
         listNode.printNodeList();
     }
}
