package org.loevc.halcyon.leetcode;

public class Q415 {

    class Solution {
        public String addStrings(String num1, String num2) {
            int len1 = num1.length();
            int len2 = num2.length();
            String add = "";
            int addLen = Math.abs(len1-len2);
            int len = 0;
            for (int i = 0; i < addLen; ++i){
                add += "0";
            }
            if (len1 > len2) {
                len = len1;
                num2 = add + num2;
            } else {
                len = len2;
                num1 = add + num1;
            }

            String head = "0";
            String res = "";
            char addLocation = '0';
            char[] chars1 = num1.toCharArray();
            char[] chars2 = num2.toCharArray();
            for (int i = len - 1; i >= 0; --i){
                int temp = chars1[i] + chars2[i] + addLocation - '0' - '0' - '0';
                if (temp > 9) {
                    addLocation = (char) (temp / 10 + '0');
                    temp = temp % 10;
                } else {
                    addLocation = '0';
                }
                res = (char)(temp + '0')  + res;
            }

            if (addLocation == '0') return res;
            else {
                return addLocation + res;
            }


        }
    }

     public static void main(String[] args) {
         Solution solution = new Q415().new Solution();
         String num1 = "9";
         String num2 = "99";
         System.out.println(solution.addStrings(num1, num2));
     }
}
