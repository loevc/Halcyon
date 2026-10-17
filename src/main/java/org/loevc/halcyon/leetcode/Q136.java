package org.loevc.halcyon.leetcode;

public class Q136 {

    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res ^= num;
            }
            return res;
        }
    }

     public static void main(String[] args) {
     }
}
