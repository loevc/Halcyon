package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            int pre = 0;
            int cur = 0;
            int res = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (cur < n) {
                if (map.containsKey(chars[cur])) {
                    // 排除 ccbbcc 类型， 如果让pre倒退是不合理的
                    pre = Math.max(map.get(chars[cur]) + 1, pre);
                    map.put(chars[cur], cur);
                    ++cur;
                } else {
                    map.put(chars[cur], cur);
                    cur++;
                }
                res = Math.max(cur - pre, res);
                System.out.println("第" + cur + "次循环，pre=" + pre + ", cur=" + cur + ", res=" + res + ", map=" + map);
            }
            return res;
        }
    }

    public static void main(String[] args) {
//         System.out.println(new Q3().new Solution().lengthOfLongestSubstring("1R1T7"));
//        System.out.println(new Q3().new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Q3().new Solution().lengthOfLongestSubstring("ccbbcc"));
    }
}
