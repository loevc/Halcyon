package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1512 {

    /**
     * 问题核心在于 1次遍历可以解决
     * 熟悉 method ： getOrDefault
     *
     * 优化： 如果小范围是否可以使用数组优化替代呢 ？
     */
    class Solution {
        public int numIdenticalPairs(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int num : nums){
                if (map.getOrDefault(num, 0) > 0){
                    ans += map.get(num);
                }
                map.put(num, map.getOrDefault(num, 0) + 1);

            }
            return ans;
        }
    }
}
