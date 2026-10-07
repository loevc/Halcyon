package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q438 {

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int k = p.length();
            int n = s.length();
            if (k > n)
                return new ArrayList();
            char[] chars = s.toCharArray();
            char[] charsP = p.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            Map<Character, Integer> temp = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < k; ++i) {
                map.put(charsP[i], map.getOrDefault(charsP[i], 0) + 1);
                temp.put(chars[i], temp.getOrDefault(chars[i], 0) + 1);
            }
            if (map.equals(temp)) {
                list.add(0);
            }
            for (int i = k; i < n; ++i) {
                if (temp.get(chars[i - k]) == 1) {
                    temp.remove(chars[i - k]);
                } else {
                    temp.put(chars[i - k], temp.get(chars[i - k]) - 1);
                }

                temp.put(chars[i], temp.getOrDefault(chars[i], 0) + 1);

                if (map.equals(temp)) {
                    list.add(i - k + 1);
                }
            }

            return list;
        }
    }

    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        map.put('c', 3);
        map.put('b', 4);
        map2.put('b', 4);
        map2.put('c', 3);
        System.out.println(map.equals(map2));

        System.out.println(new Q438().new Solution().findAnagrams("cbaebabacd", "abc"));
    }
}
