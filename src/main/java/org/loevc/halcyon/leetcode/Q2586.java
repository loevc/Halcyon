package org.loevc.halcyon.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q2586 {

    class Solution {

        final Set<Character> sets = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        public int vowelStrings(String[] words, int left, int right) {
            int res = 0;
            for (int i = left; i < right + 1; ++i) {
                String str = words[i];
                char[] chars = str.toCharArray();
                int len = chars.length;
                if (sets.contains(chars[0]) && sets.contains(chars[len - 1]))
                    ++res;
            }
            return res;
        }
    }

     public static void main(String[] args) {
     }
}
