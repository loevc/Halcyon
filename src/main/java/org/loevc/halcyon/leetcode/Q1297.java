package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1297 {

    class Solution {
        public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
            Map<String, Integer> subStrCntMap = new HashMap<>();
            Map<Character, Integer> charCntMap = new HashMap<>();
            // 思考一个问题，子串的话，如果长度是个区间，是不是说明子串的有 max-min+1 个
            // 这是子串的数量是不定中的定数
            // 是不是我可以圈定一个区间，符合max的，然后由min递增到max？

            // 还需要一个维护子串的变量

            char[] chars = s.toCharArray();
            int len = chars.length;
            for (int i = 0; i < minSize; ++i) {
                charCntMap.put(chars[i], charCntMap.getOrDefault(chars[i], 0) + 1);
            }
            String tempStr = s.substring(0, minSize);
            if (charCntMap.size() <= maxLetters) {
                subStrCntMap.put(tempStr, subStrCntMap.getOrDefault(tempStr, 0) + 1);
            }

            // 没什么思路了，看了评论区，罚时25分钟，
            // 确实 ，最大的子串 如果满足最小的子串肯定也满足的

            for (int i = minSize; i < len; ++i) {

                charCntMap.put(chars[i - minSize], charCntMap.get(chars[i - minSize]) - 1);
                // 注意频次如果为0，会影响下面判断，ai提示，罚时 8分钟
                if (charCntMap.get(chars[i - minSize]) == 0)
                    charCntMap.remove(chars[i - minSize]);
                charCntMap.put(chars[i], charCntMap.getOrDefault(chars[i], 0) + 1);
                tempStr = s.substring(i - minSize + 1, i + 1);
                if (charCntMap.size() <= maxLetters) {
                    subStrCntMap.put(tempStr, subStrCntMap.getOrDefault(tempStr, 0) + 1);
                }

            }

            int max = 0;
            for (int value : subStrCntMap.values()) {
                max = Math.max(value, max);
            }
            return max;
        }
    }

     public static void main(String[] args) {
     }
}
