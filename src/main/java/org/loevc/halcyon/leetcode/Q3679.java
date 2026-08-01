package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q3679 {

    /**
     * 问题在于，map是无序的，如果单纯用 +/- 来表示，怎么确定移除的是哪个元素呢？ 是有歧义的
     * 当 一个 大于m 的值a，在 w区间移动后，继续出现的话， map 维护的是 a 的总次数了，而不是区间内的次数了
     */
    class Solution {
        public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < w; ++i) {
                int temp = arrivals[i];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                if (map.get(temp) > m) {
                    ++res;
                    map.put(temp, map.get(temp) - 1);
                    arrivals[i] = -1;
                    map.put(-1, map.getOrDefault(-1, 0) + 1);
                }
            }
            for (int i = w; i < arrivals.length; ++i) {
                int old = arrivals[i - w];
                map.put(old, map.get(old) - 1);
                int cur = arrivals[i];
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                if (map.get(cur) > m) {
                    ++res;
                    map.put(cur, map.get(cur) - 1);
                    arrivals[i] = -1;
                    map.put(-1, map.getOrDefault(-1, 0) + 1);
                }
            }
            return res;

        }
    }

     public static void main(String[] args) {
        new Q3679().new Solution().minArrivalsToDiscard(new int[]{7,3,9,9,7,3,5,9,7,2,6,10,9,7,9,1,3,6,2,4,6,2,6,8,4,8,2,7,5,6}, 10 ,1 );
     }
}
