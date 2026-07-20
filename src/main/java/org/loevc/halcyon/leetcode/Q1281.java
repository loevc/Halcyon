package org.loevc.halcyon.leetcode;

public class Q1281 {

    class Solution {
        public int subtractProductAndSum(int n) {
            int sum = 0;
            int multi = 1;
            // 这里注意 n mod 10 == 0， 不代表n提取了全部位数
            while (n != 0) {
                int temp = n % 10;
                n /= 10;
                sum += temp;
                multi *= temp;
            }

            return multi - sum;
        }
    }

     public static void main(String[] args) {
         System.out.println(new Q1281().new Solution().subtractProductAndSum(705));
     }
}
