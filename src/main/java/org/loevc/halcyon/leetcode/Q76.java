package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q76 {

    class Solution {
        public String minWindow(String s, String t) {
            // 维护 final lr
            int fl = 0;
            int fr = 0;
            int l = 0;
            int r = 0;
            int sLen = s.length();
            int tLen = t.length();
            if (sLen < tLen)
                return "";

            Map<Character, Integer> tMap = new HashMap<>();
            for (int i = 0; i < tLen; ++i) {
                tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            }

            int min = sLen + 1;
            int valid = 0;
            Map<Character, Integer> sMap = new HashMap<>();
            while (r < sLen) {
                char c = s.charAt(r++);
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);

                if (sMap.get(c).equals(tMap.get(c))) {
                    ++valid;
                }
                while (valid == tMap.size()) {
                    char cl = s.charAt(l);
                    if (sMap.get(cl).equals(tMap.get(cl))) {

                        valid--;

                        if (r - l < min) {
                            fl = l;
                            fr = r;
                            min = fr - fl;
                        }
                    }

                    // 不会出现负数的，都是自己放进去的
                    sMap.put(cl, sMap.get(cl) - 1);
                    ++l;
                }

            }
            return min == sLen + 1 ? "" : s.substring(fl, fr);
        }
    }

     public static void main(String[] args) {
         System.out.println("res=" + new Q76().new Solution().minWindow("ADOBECODEBANC", "ABC"));
     }
}
