package org.loevc.halcyon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class QDW196Q2 {

    class Solution {
        public int minRange(int a, int b, int c) {
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (a < c) {
                int temp = a;
                a = c;
                c = temp;
            }
            if (b < c) {
                int temp = b;
                b = c;
                c = temp;
            }
            if (a > b + c) {
                return b;
            } else {
                return a - c;
            }
        }
    }

     public static void main(String[] args) {
     }
}
