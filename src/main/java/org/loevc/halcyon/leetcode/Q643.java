package org.loevc.halcyon.leetcode;

public class Q643 {

    /**
     * 注意初始化值问题
     */
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int res = 0;
            int m = 0;
            for (int i = 0; i < k; ++i) {
                m += nums[i];
            }
            res = m;
            for (int i = k; i < nums.length; ++i) {
                m -= nums[i - k];
                m += nums[i];
                res = Math.max(res, m);
            }
            return res * 1.0 / k;
        }
    }

     public static void main(String[] args) {
     }
}
