package org.loevc.halcyon.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q239 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < nums.length; ++i) {
                while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);

                int left = i - k + 1;
                // 为什么 removeFirst 可以用if 而不是 while ，以为 一直在for循环内，所以只可能最多有一个过期
                if (deque.getFirst() < left) {
                    deque.removeFirst();
                }
                if (left < 0)
                    continue;

                res[left] = nums[deque.getFirst()];
            }
            return res;

        }
    }

     public static void main(String[] args) {
     }
}
