package org.loevc.halcyon.leetcode;

import java.util.Stack;

public class Q234 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */


    class Solution {
        public boolean isPalindrome(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            ListNode slow = new ListNode(-1);
            slow.next = head;
            ListNode fast = new ListNode(-1);
            fast.next = head;
            stack.push(slow.next.val);
            if (fast.next.next == null)
                return true;
            fast.next = fast.next.next;
            int oddFlag = 1;
            while (fast.next != null) {
                slow.next = slow.next.next;
                stack.push(slow.next.val);
                fast.next = fast.next.next;
                if (fast.next == null) {
                    oddFlag = 0;
                    break;
                } else {
                    fast.next = fast.next.next;
                }
            }
            if (oddFlag == 0) {
                stack.pop();

            }
            while (!stack.isEmpty()) {
                if (slow.next.val != stack.pop())
                    return false;
                slow.next = slow.next.next;
            }
            return true;
        }
    }


    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1, new ListNode(0, new ListNode(0, null)));
        ListNode listNode = new ListNode(1, new ListNode(2, null));
        System.out.println(new Q234().new Solution().isPalindrome(listNode));
    }
}
