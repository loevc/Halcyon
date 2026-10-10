package org.loevc.halcyon.leetcode;

public class Q189 {

    class Solution {
        public void rotate(int[] nums, int k) {
            int[] temp = new int[nums.length];
            k = k - k / nums.length * nums.length;
            int a = 0;
            int idx = 0;
            for (int i = nums.length - k; i < 2 * nums.length; ++i) {
                a = i;
                if (i >= nums.length) {
                    a = i - nums.length;
                }
                temp[idx++] = nums[a];
                if (idx == nums.length)
                    break;
            }

            for (int i = 0; i < nums.length; ++i) {
                nums[i] = temp[i];
            }

        }
    }

     public static void main(String[] args) {
     }
}
