package org.loevc.halcyon.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1456 {

    class Solution {

        final Set<Character> sets = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        public int maxVowels(String s, int k) {
            int res = 0;
            int m = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < k; ++i) {
                if (sets.contains(chars[i]))
                    ++m;

            }
            res = Math.max(res, m);
            for (int i = k; i < s.length(); ++i) {
                if (sets.contains(chars[i - k]))
                    --m;
                if (sets.contains(chars[i]))
                    ++m;
                res = Math.max(res, m);
            }
            return res;
        }

    }

     public static void main(String[] args) {
     }
}
