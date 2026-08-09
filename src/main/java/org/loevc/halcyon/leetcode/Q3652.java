package org.loevc.halcyon.leetcode;

public class Q3652 {

    class Solution {
        public long maxProfit(int[] prices, int[] strategy, int k) {
            int len = prices.length;
            long origin = 0;
            for (int i = 0; i < len; ++i) {
                origin += prices[i] * strategy[i];
            }
            long temp = origin;
            temp = Math.max(temp, origin);
            for (int i = 0; i < k; ++i) {
                if (i < k / 2) {
                    origin += (0 - strategy[i]) * prices[i];
                } else {
                    origin += (1 - strategy[i]) * prices[i];
                }
            }
            temp = Math.max(temp, origin);
            for (int i = k; i < len; ++i) {
                origin -= (0 - strategy[i - k]) * prices[i - k];
                origin -= prices[i - k / 2];
                origin += (1 - strategy[i]) * prices[i];
                temp = Math.max(temp, origin);
            }
            return temp;
        }
    }

     public static void main(String[] args) {
     }
}
