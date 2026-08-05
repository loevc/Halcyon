package org.loevc.halcyon.leetcode;

public class Q3439 {

    class Solution {
        public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
            // 转换为求解 间隙的最大和，会议之间如无间隙，则值为0
            int len = startTime.length;
            int res = 0;
            int tmp = startTime[0] - 0;
            for (int i = 0; i < k - 1; ++i) {
                // 因为k 可能== len，so 这里到 k-1
                tmp += startTime[i + 1] - endTime[i];
            }
            for (int i = k - 1; i < len - 1; ++i) {
                tmp += startTime[i + 1] - endTime[i];

                res = Math.max(res, tmp);

                if (i - k < 0) {
                    tmp -= startTime[i - k + 1] - 0;
                } else {
                    tmp -= startTime[i - k + 1] - endTime[i - k];

                }
            }
            tmp += eventTime - endTime[len - 1];
            res = Math.max(res, tmp);
            return res;
        }
    }

     public static void main(String[] args) {
     }
}
