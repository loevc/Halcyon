package org.loevc.halcyon.leetcode;

import java.util.Arrays;

public class Q852 {

    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int r = arr.length - 1;
            int l = 0;
            int mid = l + (r - l) / 2;
            // l 和 r 的边界很难判断啊， 如何正确的限定边界呢？
            while (l < r) {
                if ((arr[mid] > arr[mid - 1]) && (arr[mid] > arr[mid + 1])) {
                    return mid;
                } else if ((arr[mid] > arr[mid - 1]) && (arr[mid] < arr[mid + 1])) {
                    l = mid + 1;
                } else {
                    // else 注意峰值问题，使用 r = mid - 1 是否可能越界或者漏掉值呢？
                    r = mid;
                }
                mid = l + (r - l) / 2;
            }
            return -1;
        }
    }

     public static void main(String[] args) {
         System.out.println(new Q852().new Solution().peakIndexInMountainArray(new int[]{3,4,5,1}));
     }
}
