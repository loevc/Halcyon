package org.loevc.halcyon.leetcode;

public class Q1423 {

    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            // 取反
            // k 张最大，但是从两边拿 === len-k 张最小 从中间取
            // 注意，求结果的补集
            int len = cardPoints.length;
            long temp = 0;
            long sum = 0;
            long total = 0;
            for (int i = 0; i < len - k; ++i) {
                temp += cardPoints[i];
            }
            sum = temp;
            total = temp;
            for (int i = len - k; i < len; ++i) {
                temp -= cardPoints[i - len + k];
                temp += cardPoints[i];
                sum = Math.min(sum, temp);
                total += cardPoints[i];
            }

            return (int) (total - sum);
        }
    }

     public static void main(String[] args) {
     }
}
