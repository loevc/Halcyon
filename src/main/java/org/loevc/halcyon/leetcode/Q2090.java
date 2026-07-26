package org.loevc.halcyon.leetcode;

import java.util.Arrays;

public class Q2090 {

    class Solution {
        public int[] getAverages(int[] nums, int k) {
            int len = nums.length;
            // 能不能分配一下初始化的数组的默认值都是-1呀，类似malloc
            int[] res = new int[len];
            Arrays.fill(res, -1);
            if (len < 2 * k + 1)
                return res;
            // 考虑溢出啊 ....
            long sum = 0;
            for (int i = 0; i < 2 * k + 1; ++i) {
                sum += nums[i];
            }
            int cnt = 2 * k + 1;
            for (int i = k; i < len - k; ++i) {
                res[i] = (int) (sum / cnt);
                sum -= nums[i - k];
                if (i + k + 1 >= len)
                    break;
                sum += nums[i + k + 1];
            }
            return res;
        }
    }

     public static void main(String[] args) {
        new Q2090().new Solution().getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3);
     }
}
