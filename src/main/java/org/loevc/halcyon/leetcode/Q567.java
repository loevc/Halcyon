package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q567 {

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s2.length() < s1.length())
                return false;
            int[] letters = new int[26];
            for (char c : s1.toCharArray()) {
                ++letters[c - 'a'];
            }

            int k = s1.length();
            Map<Character, Integer> map = new HashMap<>();
            char[] charS2 = s2.toCharArray();
            for (int i = 0; i < k; ++i) {
                map.put(charS2[i], map.getOrDefault(charS2[i], 0) + 1);
            }
            boolean temp = true;
            for (char c : map.keySet()) {
                if (map.get(c) == letters[c - 'a'])
                    temp &= true;
                else {
                    temp &= false;
                }
            }
            if (temp)
                return true;
            for (int i = k; i < s2.length(); ++i) {
                map.put(s2.charAt(i - k), map.get(s2.charAt(i - k)) - 1);
                map.put(charS2[i], map.getOrDefault(charS2[i], 0) + 1);

                temp = true;
                for (char c : map.keySet()) {
                    if (map.get(c) == letters[c - 'a'])
                        temp &= true;
                    else {
                        temp &= false;
                    }
                }
                if (temp)
                    return true;
            }
            return false;
        }
    }

     public static void main(String[] args) {
     }
}
