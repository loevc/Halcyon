package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1888 {

    /**
     * 这种奇偶计算，我理解有问题，这个题目用了2个半小时，还看了提示、讨论和答案，用时是有问题的，并且理解程度很弱
     */
    class Solution {
        public int minFlips(String s) {
            // 类型1 有用吗？ ta 可以把首字母的定位出来？
            // 10分钟还是没有思路，超时失败
            Map<Integer, Integer> oddMap = new HashMap<>();
            Map<Integer, Integer> evenMap = new HashMap<>();
            oddMap.put(0, 0);
            oddMap.put(1, 0);
            evenMap.put(0, 0);
            evenMap.put(1, 0);

            char[] chars = s.toCharArray();
            int len = s.length();
            if ((len & 1) == 0) {
                for (int i = 0; i < chars.length; ++i) {
                    if ((i & 1) == 0) {
                        if (chars[i] == '0') {
                            oddMap.put(0, oddMap.get(0) + 1);
                        } else {
                            oddMap.put(1, oddMap.get(1) + 1);
                        }
                    } else {
                        if (chars[i] == '0') {
                            evenMap.put(0, evenMap.get(0) + 1);
                        } else {
                            evenMap.put(1, evenMap.get(1) + 1);
                        }
                    }

                }
                return Math.min(oddMap.get(0) + evenMap.get(1), oddMap.get(1) + evenMap.get(0));
            } else {
                // 奇数长度的s ，旋转后排布不一样
                // 偶奇偶 ----  奇偶偶
                s += s;
                chars = s.toCharArray();
                int res = 0;
                for (int i = 0; i < len; ++i) {
                    if ((i & 1) == 0) {
                        if (chars[i] == '0') {
                            oddMap.put(0, oddMap.get(0) + 1);
                        } else {
                            oddMap.put(1, oddMap.get(1) + 1);
                        }
                    } else {
                        if (chars[i] == '0') {
                            evenMap.put(0, evenMap.get(0) + 1);
                        } else {
                            evenMap.put(1, evenMap.get(1) + 1);
                        }
                    }
                }
                res = Math.min(oddMap.get(0) + evenMap.get(1), oddMap.get(1) + evenMap.get(0));

                for (int i = len; i < s.length(); ++i) {
                    // 先减去被移除的元素

                    if (chars[i - len] == '0') {
                        oddMap.put(0, oddMap.get(0) - 1);
                    } else {
                        oddMap.put(1, oddMap.get(1) - 1);
                    }

                    Map temp = oddMap;
                    oddMap = evenMap;
                    evenMap = temp;
                    // 再加上新加入的元素

                    if (chars[i] == '0') {
                        oddMap.put(0, oddMap.get(0) + 1);
                    } else {
                        oddMap.put(1, oddMap.get(1) + 1);
                    }

                    // 这里错了，之前一直返回的 两个map的最小值，并没有实际更新res，每次的res都是当前的最小值，应该取全部循环的最小值
                    int min = Math.min(oddMap.get(0) + evenMap.get(1), oddMap.get(1) + evenMap.get(0));
                    res = Math.min(min, res);
                }

                return res;
            }

        }
    }

     public static void main(String[] args) {
     }
}
