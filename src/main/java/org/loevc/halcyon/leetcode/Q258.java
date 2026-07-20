package org.loevc.halcyon.leetcode;

public class Q258 {

    /**
     * 递归： 找好终止条件， 然后确认子问题
     */
    class Solution {
        public int addDigits(int num) {
            return recursive(num);
        }

        private int recursive(int num) {
            // 终止条件
            if (num / 10 == 0)
                return num;

            // 子问题
            int temp = 0;
            while (num != 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
            return recursive(num);

        }
    }

     public static void main(String[] args) {
     }
}
