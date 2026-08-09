package org.loevc.halcyon.leetcode;

import java.util.*;

public class QW514Q2 {

    /**
     * 还是不行 TLE， 就是深度计算太慢了， 需要优化
     * 中间应该可以记录一下遍历过的，不单单是相同的，不同的，应该也可以记录一下， 这样就不需要重复计算了
     */
    class Solution {
        public long weightedSum(int[] parent, int[] nums) {

            int len = parent.length;
            long[] ds = new long[len];
            Arrays.fill(ds, 1);

            Map<Integer, Long> depthMap = new HashMap<>();

            long h = 1;
            for (int i = 0; i < len; ++i) {
                if (i == 0)
                    continue;
                if (depthMap.containsKey(parent[i])) {
                    ds[i] = depthMap.get(parent[i]);
                } else {
                    long depth = depthCompute(parent, i);
                    depthMap.put(parent[i], depth);
                    ds[i] = depth;
                    h = Math.max(h, depth);
                }

            }

            long res = 0;
            for (int i = 0; i < len; ++i) {
                res += nums[i] * 1L * (h - ds[i] + 1) ;
            }

            return res;
        }

        private long depthCompute(int[] parent, int index) {

            if (index == -1)
                return 0L;
            return 1 + depthCompute(parent, parent[index]);
//            return ++depthCompute(parent, parent[index]);

        }
    }

    public static void main(String[] args) {
        System.out.println(new QW514Q2().new Solution().weightedSum(new int[]{-1, 0, 0, 2, 1}, new int[]{23, 63, 38, 82, 15}));
    }
}
