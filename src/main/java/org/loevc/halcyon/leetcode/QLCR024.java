package org.loevc.halcyon.leetcode;

public class QLCR024 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode temp = cur;
                cur = cur.next;
                temp.next = pre;
                pre = temp;
            }
            return pre;
        }
    }

     public static void main(String[] args) {
     }
}
