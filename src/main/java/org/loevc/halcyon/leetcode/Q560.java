package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q560 {

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] pre = new int[n + 1];
            pre[0] = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                pre[i + 1] = pre[i] + nums[i];
            }
            int cnt = 0;
            map.put(pre[0], 1);
            for (int j = 1; j < n + 1; ++j) {

                if (map.containsKey(pre[j] - k)) {
                    cnt += map.get(pre[j] - k);
                }
                map.put(pre[j], map.getOrDefault(pre[j], 0) + 1);
            }
            return cnt;

        }
    }

    public static void main(String[] args) {
//         System.out.println(new Q560().new Solution().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new Q560().new Solution().subarraySum(new int[]{1, 2, 3}, 3));
    }
}
