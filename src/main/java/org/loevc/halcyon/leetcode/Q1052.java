package org.loevc.halcyon.leetcode;

public class Q1052 {

    /**
     * 894s
     * 注意 变量不要用错了
     */
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int len = customers.length;
            int score = 0;
            int extra = 0;
            for (int i = 0; i < minutes; ++i) {
                if (grumpy[i] == 1)
                    extra += customers[i];
                score += customers[i] * (1 - grumpy[i]);
            }
            int max = extra;
            for (int i = minutes; i < len; ++i) {
                if (grumpy[i - minutes] == 1)
                    extra -= customers[i - minutes];
                if (grumpy[i] == 1)
                    extra += customers[i];
                max = Math.max(extra, max);
                score += customers[i] * (1 - grumpy[i]);
            }

            return score + max;
        }
    }

     public static void main(String[] args) {
     }
}
