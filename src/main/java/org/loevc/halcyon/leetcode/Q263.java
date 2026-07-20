package org.loevc.halcyon.leetcode;

public class Q263 {

    /**
     * 是否有其他处理方法呢
     * 这个方案好low
     */
    class Solution {
        public boolean isUgly(int n) {
            if (n <= 0)
                return false;
            while (n != 1) {
                if (n % 5 == 0) {
                    n /= 5;
                    continue;
                }

                if (n % 3 == 0) {
                    n /= 3;
                    continue;
                }
                if (n % 2 == 0) {
                    n /= 2;
                    continue;
                }

                return false;
            }
            return true;
        }
    }

     public static void main(String[] args) {
     }
}
