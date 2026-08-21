package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int res = 0;
            int l = 0;
            int r = 0;
            int temp = 0;
            Set<Character> sets = new HashSet<>();
            Map<Character, Integer> map = new HashMap<>();
            while (r < chars.length) {
                char c = chars[r];
                if (sets.contains(c)) {
                    sets.clear();
                    res = Math.max(res, temp);
                    temp = 0;
                    r = map.get(c) + 1;
                    map.clear();
                } else {
                    map.put(c, r);
                    ++temp;
                    ++r;
                    sets.add(c);
                }
            }
            res = Math.max(res, temp);
            return res;
        }
    }

     public static void main(String[] args) {
         System.out.println(new Q3().new Solution().lengthOfLongestSubstring("1R1T7"));
     }
}
