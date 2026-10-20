package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q146 {

    class LRUCache {

        int capacity;

        Map<Integer, ListNode> map = new HashMap<>();

        ListNode head = new ListNode(0, 0);
        ListNode tail = new ListNode(0, 0);

        // 把 key 和 value 关联起来，因为找到对应的节点，map要同步删除
        class ListNode {
            int key;
            int val;
            ListNode prev;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            ListNode node = map.get(key);
            if (node == null)
                return -1;
            move2Head(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (capacity <= 0)
                return;
            ListNode node = map.get(key);
            if (node != null) {
                node.val = value;
                move2Head(node);
                return;
            }
            if (capacity == map.size()) {
                ListNode old = tail.prev;
                map.remove(old.key);
                removeNode(old);
            }
            node = new ListNode(key, value);
            map.put(key, node);
            add2Head(node);
        }

        // 核心问题： 想明白对节点的操作， 新增，删除，移动

        private void add2Head(ListNode node) {
            ListNode cur = head.next;
            node.next = cur;
            cur.prev = node;
            head.next = node;
            node.prev = head;

        }

        private void removeNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;

        }

        private void move2Head(ListNode node) {
            removeNode(node);
            add2Head(node);
        }
    }


    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {
        LRUCache cache = new Q146().new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
