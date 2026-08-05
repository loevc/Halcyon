package org.loevc.halcyon.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q3694 {

    class Solution {
        public int distinctPoints(String s, int k) {
            char[] chars = s.toCharArray();
            // UDLR 0123
            int[] locations = new int[4];
            Set<String> sets = new HashSet<>();

            for (int i = 0; i < chars.length; ++i) {
                if (chars[i] == 'U') {
                    ++locations[0];
                } else if (chars[i] == 'D') {
                    ++locations[1];
                } else if (chars[i] == 'L') {
                    ++locations[2];
                } else {
                    ++locations[3];
                }
            }
            int pairU = locations[0];
            int pairL = locations[2];
            for (int i = 0; i < k; ++i) {
                if (chars[i] == 'U') {
                    --locations[0];
                } else if (chars[i] == 'D') {
                    --locations[1];
                } else if (chars[i] == 'L') {
                    --locations[2];
                } else {
                    --locations[3];
                }
            }
            pairU = Math.min(locations[0], locations[1]);
            pairL = Math.min(locations[2], locations[3]);
            sets.add("" + trans(locations[0] - pairU) + trans(locations[1] - pairU) + trans(locations[2] - pairL)
                    + trans(locations[3] - pairL));
            for (int i = k; i < chars.length; ++i) {
                if (chars[i - k] == 'U') {
                    ++locations[0];
                } else if (chars[i - k] == 'D') {
                    ++locations[1];
                } else if (chars[i - k] == 'L') {
                    ++locations[2];
                } else {
                    ++locations[3];
                }

                if (chars[i] == 'U') {
                    --locations[0];
                } else if (chars[i] == 'D') {
                    --locations[1];
                } else if (chars[i] == 'L') {
                    --locations[2];
                } else {
                    --locations[3];
                }
                pairU = Math.min(locations[0], locations[1]);
                pairL = Math.min(locations[2], locations[3]);
                sets.add("" + trans(locations[0] - pairU) + trans(locations[1] - pairU) + trans(locations[2] - pairL)
                        + trans(locations[3] - pairL));
            }
            return sets.size();
        }

        private String trans(int num) {
            if (num == 0)
                return "000000";
            String temp = Integer.toString(num);
            int len = temp.length();
            int zero = 6 - len;
            String zeroStr = "";
            while (zero-- > 0) {
                zeroStr += "0";
            }
            return zeroStr + temp;
        }
    }

     public static void main(String[] args) {
        // 测试 y7000p 电脑 git 和 windows 证书问题 1
     }
}
