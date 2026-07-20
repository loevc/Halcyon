package org.loevc.halcyon.leetcode;

public class Q1470 {

    /**
     * 无他，找好对应关系
     */
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] res = new int[2 * n];
            for (int i = 0; i < n; ++i) {
                res[2 * i] = nums[i];
                res[2 * i + 1] = nums[n + i];
            }
            return res;
        }
    }

     public static void main(String[] args) {
     }
}
