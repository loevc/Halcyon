package org.loevc.halcyon.leetcode;

public class Q1486 {

    /**
     * 感觉这个问题的核心是 2n，
     * 如果是kn，那么无法利用二进制的特性来了
     * 因为是2n，所以最后一位可以很暴力的舍弃，完全根据start和n来决定， 按位右移直接舍弃最后一位等同除以2，同时把start + 2n，变成了 start/2 + n
     */
    class Solution {
        public int xorOperation(int n, int start) {
            int ans = Xor(start / 2 + n - 1) ^ Xor(start / 2 - 1);
            return (ans << 1) + ((n & 1) & (start & 1));
        }

        private int Xor(int k) {
            int a = k % 4;
            int ans = 0;
            switch (a) {
                case 0:
                    ans = k;
                    break;
                case 1:
                    ans = 1;
                    break;
                case 2:
                    ans = k + 1;
                    break;
                default:
                    ans = 0;
                    break;
            }
            return ans;
        }
    }
}
