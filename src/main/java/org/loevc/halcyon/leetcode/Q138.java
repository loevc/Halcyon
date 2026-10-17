package org.loevc.halcyon.leetcode;

public class Q138 {

    /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    /**
     * 使用了3次while 能加速吗？
     */
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null)
                return head;
            Node cur = head;
            while (cur != null) {
                Node node = new Node(cur.val);
                node.next = cur.next;
                cur.next = node;
                node.random = cur.random;
                cur = cur.next.next;
            }
            cur = head;
            while (cur != null) {
                Node next = cur.next;
                if (cur.random == null)
                    next.random = null;
                else {
                    next.random = cur.random.next;
                }
                cur = cur.next.next;
            }
            cur = head;
            Node dummy = head.next;
            while (cur != null) {
                Node next = cur.next;
                Node pre = cur;
                cur = cur.next.next;
                pre.next = cur;
                if (cur != null)
                    next.next = cur.next;
                else {
                    next.next = null;
                }
            }
            return dummy;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node.random = null;
        node1.random = node;
        node2.random = node4;
        node3.random = node2;
        node4.random = node;

        System.out.println(new Q138().new Solution().copyRandomList(node));
        System.out.println();
        new Q138().new Solution().copyRandomList(node).printNodeList();
        node.printNodeList();
    }
}
