package org.loevc.halcyon.leetcode;

import java.util.Random;

public class Q912 {

    class Solution {

        private final Random rand = new Random();

        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            boolean ordered = true;
            for (int i = left; i < right; ++i) {
                if (nums[i] > nums[i + 1])
                    ordered = false;
            }
            if (ordered)
                return;
            int i = partition(nums, left, right);
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }

        private int partition(int[] nums, int left, int right) {
            int i = left + rand.nextInt(right - left + 1);
            int pivot = nums[i];
            swap(nums, i, left);
            i = left + 1;
            int j = right;

            while (true) {
                while (i <= j && nums[i] < pivot) {
                    ++i;
                }
                while (i <= j && nums[j] > pivot) {
                    --j;
                }
                if (i >= j) {
                    break;
                }
                swap(nums, i++, j--);
            }

            swap(nums, left, j);
            return j;

        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

     public static void main(String[] args) {
        new Q912().new Solution().sortArray(new int[]{5, 2, 3, 1});
     }
}
