package org.loevc.halcyon.leetcode;

public class Q2379 {

    class Solution {
        public int minimumRecolors(String blocks, int k) {
            // 求出现B的最大值就行，如果和k相同，那么结果就是 k - cnt
            int cnt = 0;
            int m = 0;
            char[] chars = blocks.toCharArray();
            for (int i = 0; i < k; ++i) {
                if (chars[i] == 'B')
                    ++m;
            }
            cnt = m;
            if (cnt == k)
                return 0;
            for (int i = k; i < chars.length; ++i) {
                if (chars[i - k] == 'B')
                    --m;
                if (chars[i] == 'B')
                    ++m;
                cnt = Math.max(m, cnt);
            }
            return k - cnt;
        }
    }

     public static void main(String[] args) {
     }
}
