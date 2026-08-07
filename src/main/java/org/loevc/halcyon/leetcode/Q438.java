package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q438 {

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            if (p.length() > s.length())
                return new ArrayList();
            List<Integer> list = new ArrayList<>();

            int k = p.length();
            char[] chars = s.toCharArray();
            int[] letters = new int[26];
            for (char c : p.toCharArray()) {
                ++letters[c - 'a'];
            }

            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < k; ++i) {
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);

            }
            boolean res = true;
            for (char c : map.keySet()) {
                if (map.get(c) != letters[c - 'a'])
                    res = false;
            }
            if (res)
                list.add(0);
            for (int i = k; i < s.length(); ++i) {
                map.put(chars[i - k], map.get(chars[i - k]) - 1);
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
                res = true;
                for (char c : map.keySet()) {
                    if (map.get(c) != letters[c - 'a'])
                        res = false;
                }
                if (res)
                    list.add(i - k + 1);
            }

            return list;
        }
    }

     public static void main(String[] args) {
     }
}
