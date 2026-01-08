package org.loevc.cloud.halcyon.admin.algorithm;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        lengthOfLongestSubstring("bbbbb");
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int res = 1;
        Set<Character> set = new HashSet<>();
        set.add(chars[right++]);
        while (right < s.length()) {

            if (!set.contains(chars[right])) {
                set.add(chars[right]);
                ++right;
            } else {
                set.remove(chars[right]);
                ++left;
                ++right;
                if (right < s.length())
                    set.add(chars[right]);
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

}
