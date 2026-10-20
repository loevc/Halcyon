package org.loevc.halcyon.leetcode;

public class Q23 {

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
     * 看到这个题目，第一想法肯定是分治啊，但是数组和链表都改如何分治呢？
     * 数组是 用 left right 标记
     * 链表用 slow fast 标记
     *
     * 分治还需要理解，这个题目和上个利用链表的题目都思考阻塞
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            // 分治
            if (lists.length == 0)
                return null;
            return mergeRange(lists, 0, lists.length - 1);
        }

        private ListNode mergeRange(ListNode[] list, int left, int right) {
            if (left == right)
                return list[left];
            int mid = left + (right - left) / 2;
            ListNode head = mergeRange(list, left, mid);
            ListNode head2 = mergeRange(list, mid + 1, right);
            return mergeList(head, head2);
        }

        private ListNode mergeList(ListNode head, ListNode head2) {
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (head != null && head2 != null) {
                if (head.val <= head2.val) {
                    cur.next = head;
                    head = head.next;
                } else {
                    cur.next = head2;
                    head2 = head2.next;
                }
                cur = cur.next;
            }
            cur.next = head == null ? head2 : head;
            return dummy.next;
        }
    }

     public static void main(String[] args) {
     }
}
