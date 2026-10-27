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
            int slowMax = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (fast <= chars.length - 1) {
                if (map.isEmpty()) {
                    map.put(chars[fast], fast);
                    max = Math.max(max, fast - slow + 1);
                    fast++;
                    continue;
                }
                if (map.containsKey(chars[fast])) {
                    slow = map.get(chars[fast]) + 1;
                    if (slow < slowMax) {
                        slow = slowMax;
                    } else {
                        slowMax = slow;
                    }
                    map.remove(chars[fast]);
                }
                map.put(chars[fast], fast);
                max = Math.max(max, fast - slow + 1);
                fast++;
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
