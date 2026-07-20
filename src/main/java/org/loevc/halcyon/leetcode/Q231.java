package org.loevc.halcyon.leetcode;

public class Q231 {

    /**
     * 可以不用循环哦
     * 负数 不满足2的整数次幂
     */
    class Solution {
        public boolean isPowerOfTwo(int n) {
            // 判断二进制中1 的个数
            int cnt = 0;
            // long l = n & 0xFFFFFFFFL;
            long l = n;
            while (l != 0) {
                cnt += l & 1;
                l >>>= 1;
            }

            return cnt == 1;

        }
    }

     public static void main(String[] args) {
     }
}
