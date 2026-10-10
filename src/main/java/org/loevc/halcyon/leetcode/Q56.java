package org.loevc.halcyon.leetcode;

import java.util.Arrays;

public class Q56 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            // 先根据0列 排序
            sort(intervals);

            int m = intervals.length;
            int n = intervals[0].length;
            int[][] res = new int[m][n];
            int temp = intervals[0][1];
            int left = 0;
            int idx = 0;
            for (int i = 0; i < intervals.length - 1; ++i) {
                if (temp >= intervals[i + 1][0]) {
                    temp = Math.max(temp, intervals[i + 1][1]);
                } else {
                    res[idx][0] = intervals[left][0];
                    res[idx][1] = temp;
                    ++idx;
                    left = i + 1;
                    temp = intervals[left][1];
                }

            }
            if (left <= intervals.length - 1) {
                res[idx][0] = intervals[left][0];
                res[idx][1] = temp;
                ++idx;
            }
            return Arrays.copyOf(res, idx);
        }

        private void sort(int[][] intervals) {
            for (int i = 0; i < intervals.length; ++i) {
                for (int j = i + 1; j < intervals.length; ++j) {
                    if (intervals[i][0] > intervals[j][0]) {
                        intervals[i][0] = intervals[j][0] ^ intervals[i][0];
                        intervals[j][0] = intervals[j][0] ^ intervals[i][0];
                        intervals[i][0] = intervals[j][0] ^ intervals[i][0];
                        intervals[i][1] = intervals[j][1] ^ intervals[i][1];
                        intervals[j][1] = intervals[j][1] ^ intervals[i][1];
                        intervals[i][1] = intervals[j][1] ^ intervals[i][1];
                    }
                }
            }
        }
    }

     public static void main(String[] args) {
//         System.out.println(Arrays.deepToString(new Q56().new Solution().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
         System.out.println(Arrays.deepToString(new Q56().new Solution().merge(new int[][]{{1,4},{4,5}})));
     }
}
