package org.loevc.halcyon.leetcode;

public class Q1343 {

    class Solution {
        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int targetSum = threshold * k;
            int cnt = 0;
            int m = 0;
            for (int i = 0; i < k; ++i) {

                m += arr[i];
            }
            if (m >= targetSum)
                ++cnt;

            for (int i = k; i < arr.length; ++i) {
                m -= arr[i - k];
                m += arr[i];
                if (m >= targetSum)
                    ++cnt;
            }
            return cnt;
        }
    }

     public static void main(String[] args) {
     }
}
