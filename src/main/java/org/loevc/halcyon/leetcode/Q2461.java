package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q2461 {

    class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            long sum = 0L;
            long temp = 0L;
            for (int i = 0; i < k; ++i) {
                temp += nums[i];
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            if (map.size() == k)
                sum = temp;
            for (int i = k; i < nums.length; ++i) {

                if (map.get(nums[i - k]) == 1)
                    map.remove(nums[i - k]);
                else {
                    map.put(nums[i - k], map.get(nums[i - k]) - 1);
                }

                temp -= nums[i - k];
                temp += nums[i];
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (map.size() == k)
                    sum = Math.max(sum, temp);

            }
            return sum;
        }
    }

     public static void main(String[] args) {
     }
}
