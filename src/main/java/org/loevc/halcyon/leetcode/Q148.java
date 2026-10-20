package org.loevc.halcyon.leetcode;

public class Q148 {

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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode head2 = midNode(head);

//            当前方法保留自己的 head 和 head2，暂时等待下一层执行；下一层返回一个结果后，当前方法再用这个结果更新自己的 head
            head = sortList(head);
            head2 = sortList(head2);

            return MergeListNode(head, head2);

        }

        private ListNode midNode(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode slow = head;
            ListNode fast = head;
            ListNode pre = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                pre = slow;
                slow = slow.next;
            }
            pre.next = null;
            return slow;
        }

        private ListNode MergeListNode(ListNode head1, ListNode head2) {
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (head1 != null && head2 != null) {
                if (head1.val <= head2.val) {
                    cur.next = head1;
                    head1 = head1.next;
                } else {
                    cur.next = head2;
                    head2 = head2.next;
                }
                cur = cur.next;
            }
            cur.next = head1 == null ? head2 : head1;
            return dummy.next;
        }
    }

     public static void main(String[] args) {
     }
}
