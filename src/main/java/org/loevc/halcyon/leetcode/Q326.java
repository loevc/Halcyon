package org.loevc.halcyon.leetcode;

public class Q326 {

    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n <= 0)
                return false;
            while (n != 1) {
                if (n % 3 != 0)
                    return false;
                n /= 3;
            }
            return true;
        }
    }

     public static void main(String[] args) {
         System.out.println(new Q326().new Solution().isPowerOfThree(27));
     }
}
