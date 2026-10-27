package org.loevc.halcyon.leetcode;

public class Q25 {

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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode slow = head;
            ListNode fast = head;
            for (int i = 0; i < k; ++i) {
                fast = fast.next;
            }
            ListNode dummy = reverse(slow, k);
            slow.next = fast;
            int cnt = 0;
            while (fast != null) {
                for (int i = 0; i < k; ++i) {
                    fast = fast.next;
                    ++cnt;
                    if (fast == null)
                        break;
                }
                if (cnt != k)
                    break;
                ListNode lastTail = slow;
                slow = slow.next;
                ListNode temp = reverse(slow, k);
                lastTail.next = temp;
                slow.next = fast;
                cnt = 0;
            }
            return dummy;
        }

        private ListNode reverse(ListNode head, int k) {
            if (head == null || head.next == null)
                return head;
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null && k > 0) {
                ListNode temp = cur;
                cur = cur.next;
                temp.next = pre;
                pre = temp;
                --k;
            }
            return pre;
        }
    }

     public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        值传递的问题， listNode传递的值，所以这个函数执行完，无法修改listNode的地址，这个地址就是最开始的节点地址，会只想初始化的0 ，结果 1->0
//        new Q25().new Solution().reverse(listNode, 5).printNodeList();
         listNode = new Q25().new Solution().reverseKGroup(listNode, 2);

         listNode.printNodeList();
     }
}
