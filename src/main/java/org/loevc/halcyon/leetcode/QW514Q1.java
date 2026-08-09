package org.loevc.halcyon.leetcode;

import java.util.Arrays;

public class QW514Q1 {

    class Solution {
        public double minPrice(int[] prices, int[] discounts) {
            int len = Math.min(discounts.length, prices.length);
            Arrays.sort(prices);
            Arrays.sort(discounts);
            double res = 0.0;
            for (int i = 0; i < len; ++i) {
                res += (prices[prices.length - 1 - i] * (100 - discounts[discounts.length - 1 - i])) / 100.00;
            }
            for (int i = prices.length - len - 1; i >= 0; --i) {
                res += prices[i];
            }
            return res;
        }
    }

     public static void main(String[] args) {
         System.out.println(new QW514Q1().new Solution().minPrice(new int[]{10, 30, 21}, new int[]{50, 60}));
     }
}
