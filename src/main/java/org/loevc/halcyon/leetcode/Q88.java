package org.loevc.halcyon.leetcode;

public class Q88 {

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int idx1 = m - 1;
            int idx2 = n - 1;
            int cur = m + n - 1;
            while (idx1 >= 0 && idx2 >= 0) {
                if (nums1[idx1] <= nums2[idx2]) {
                    nums1[cur--] = nums2[idx2--];
                } else {
                    nums1[cur--] = nums1[idx1--];
                }
            }
            if (idx1 < 0) {
                for (int i = idx2; idx2 >= 0; --i) {
                    nums1[cur--] = nums2[idx2--];
                }
            }
        }
    }

     public static void main(String[] args) {
     }
}
