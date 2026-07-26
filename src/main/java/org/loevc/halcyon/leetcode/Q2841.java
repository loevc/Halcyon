package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Q2841 {

    class Solution {
        public long maxSum(List<Integer> nums, int m, int k) {
            // 维护一个map 来记录size和m的关系
            Map<Integer, Integer> map = new HashMap<>();
            long temp = 0;
            long sum = 0;
            Queue<Integer> queue = new LinkedBlockingQueue<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                queue.add(num);
                temp += num;
                if (queue.size() >= k) {
                    if (map.size() >= m) {
                        sum = Math.max(sum, temp);
                    }
                    int first = queue.poll();
                    if (map.get(first) == 1) {
                        map.remove(first);
                    } else {
                        map.put(first, map.get(first) - 1);
                    }
                    temp -= first;
                }
            }
            return sum;
        }
    }
     public static void main(String[] args) {
     }
}
