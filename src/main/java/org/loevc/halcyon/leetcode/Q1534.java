package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1534 {

    /**
     * TODO 应该还有其他解法
     * 目前是最暴力的解法
     */
    class Solution {
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int ans = 0;
            int len = arr.length;
            for (int i = 0; i < len; ++i) {
                for (int j = i + 1; j < len; ++j) {
                    if (Math.abs(arr[i] - arr[j]) > a)
                        continue;
                    for (int k = j + 1; k < len; ++k) {
                        if (Math.abs(arr[k] - arr[j]) <= b
                                && Math.abs(arr[k] - arr[i]) <= c)
                            ++ans;
                    }
                }
            }
            return ans;
        }
    }
}
