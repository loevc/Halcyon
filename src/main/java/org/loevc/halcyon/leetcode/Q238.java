package org.loevc.halcyon.leetcode;

public class Q238 {

    /**
     * prefix/suffix product
     */
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] pre = new int[n + 1];
            int[] suf = new int[n + 1];
            pre[0] = 1;
            suf[n] = 1;
            for (int i = 1; i < n; ++i) {
                pre[i] = pre[i - 1] * nums[i - 1];
            }
            for (int i = n - 1; i >= 0; --i) {
                suf[i] = suf[i + 1] * nums[i];
            }

            int[] res = new int[n];
            for (int i = 0; i < n; ++i) {
                res[i] = pre[i] * suf[i + 1];
            }
            return res;
        }
    }

     public static void main(String[] args) {
     }
}
