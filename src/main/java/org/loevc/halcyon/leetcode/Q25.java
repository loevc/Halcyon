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

    /**
     * 没有一个方法能看，怎么写的这么垃圾，两个方法都是！
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;
            for (int i = 0; i < k-1; ++i) {
                fast = fast.next;
            }
            ListNode dummy = fast;
            fast = fast.next;
            ListNode tail = reverse(slow, k);
            while (fast != null) {
                slow = fast;
                for (int i = 0; i < k-1; ++i) {
                    fast = fast.next;
                    if (fast == null)
                        break;
                }
                if (fast == null){
                    tail.next = slow;
                    break;
                }
                ListNode dummy2 = fast;
                tail.next = dummy2;
                fast = fast.next;
                tail = reverse(slow, k);
            }
            return dummy;
        }

        // 应该返回尾部节点
        private ListNode reverse(ListNode head, int k) {
            if (head == null || head.next == null)
                return head;
            ListNode cur = new ListNode();
            ListNode tail = head;
            ListNode pre = head;
            while (k-- > 0) {
                pre = pre.next;
                head.next = cur;
                cur = head;
                head = pre;
            }
            tail.next = null;
            return tail;
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
