package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30 {

    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int len = words[0].length() * words.length;
            if (len > s.length())
                return new ArrayList<>();

            int sublen = words[0].length();
            List<Integer> list = new ArrayList<>();

            Map<String, Integer> map = new HashMap<>();
            for (String str : words) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }

            boolean lastFlag = false;
            // 核心应该减少这个外循环
            for (int i = 0; i < s.length() - len + 1; ++i) {
                String str = s.substring(i, i + len);
                boolean flag = true;
                // 这里肯定是不对的，只是特化的测试用例，必然有更好的解决办法
                if (sublen == 1 && lastFlag == true && s.charAt(i - 1) == s.charAt(i + len - 1)) {
                    flag = true;
                } else {
                    Map<String, Integer> tempMap = new HashMap<>();

                    for (int j = 0; j < len; j += sublen) {
                        String tempStr = str.substring(j, j + sublen);
                        if (!map.containsKey(tempStr)) {
                            flag = false;
                            break;
                        }
                        tempMap.put(tempStr, tempMap.getOrDefault(tempStr, 0) + 1);
                        if (tempMap.get(tempStr) > map.get(tempStr)) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (flag) {
                    lastFlag = true;
                    list.add(i);
                } else {
                    lastFlag = false;
                }

            }
            return list;
        }
    }

     public static void main(String[] args) {
     }
}
