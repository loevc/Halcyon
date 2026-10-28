package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int slow = 0;
            int fast = 0;
            int max = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (fast < chars.length) {
                if (map.containsKey(chars[fast])) {
                    slow = Math.max(slow, map.get(chars[fast]) + 1);
                }
                map.put(chars[fast], fast);
                max = Math.max(max, ++fast - slow);

            }
            return max;
        }
    }

    public static void main(String[] args) {
//         System.out.println(new Q3().new Solution().lengthOfLongestSubstring("1R1T7"));
//        System.out.println(new Q3().new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Q3().new Solution().lengthOfLongestSubstring("ccbbcc"));
    }
}
