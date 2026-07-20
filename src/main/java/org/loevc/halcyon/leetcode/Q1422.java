package org.loevc.halcyon.leetcode;

public class Q1422 {

    class Solution {
        public int maxScore(String s) {
            // 假设： 指针位于p，
            // 左侧，0 有 a 个，1 有 p-a + 1 个
            // 右侧： 1 有 n - 0的总数 - （p-a + 1 ）个，0 的总数记为cnt。
            // 则，右侧 1 的分数， n - cnt - p + a - 1
            // 那么题目中总分为： n - cnt - p + 2a -1
            // 求最大值，也就是求 2a -p  的最大值
            int n = s.length();
            char[] chars = s.toCharArray();
            int temp = 0;
            int cntA = 0;
            int res = 0;
            int maxTemp = 0;
            for (int i = 0; i < n; ++i) {
                if (chars[i] == '0') {
                    ++cntA;
                }
                temp = 2 * cntA - i;
                // 分割子串，保证两边都有值
                if ((i == (n - 1)))
                    continue;
                maxTemp = Math.max(maxTemp, temp);
            }
            res = n - cntA + maxTemp - 1;
            return res;
        }
    }

     public static void main(String[] args) {
     }
}
