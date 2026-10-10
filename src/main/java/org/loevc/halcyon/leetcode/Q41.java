package org.loevc.halcyon.leetcode;

public class Q41 {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; ++i) {
                while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                    int targetIdx = nums[i] - 1;
                    int temp = nums[targetIdx];
                    nums[targetIdx] = nums[i];
                    nums[i] = temp;
                }
            }
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != i + 1)
                    return i + 1;
            }
            return nums.length + 1;
        }
    }

     public static void main(String[] args) {
     }
}
