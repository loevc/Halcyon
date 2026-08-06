package org.loevc.halcyon.leetcode;

public class Q1652 {

    class Solution {
        public int[] decrypt(int[] code, int k) {
            if (k == 0)
                return new int[code.length];
            int len = code.length;

            int[] res = new int[len];
            if (k > 0) {
                return windows(code, k, len);
            } else {
                return reWindows(code, k, len);
            }
        }

        private int[] windows(int[] code, int k, int len) {
            int temp = 0;
            int[] res = new int[code.length];
            for (int i = 0; i < k; ++i) {
                temp += code[i];
            }
            res[len - 1] = temp;
            for (int i = k; i < code.length + k; ++i) {
                temp -= code[i - k];
                if (i >= len) {
                    temp += code[i - len];
                } else {
                    temp += code[i];
                }
                res[i - k] = temp;
            }
            return res;
        }

        private int[] reWindows(int[] code, int k, int len) {
            int temp = 0;
            int[] res = new int[code.length];
            for (int i = len - 1; i > len - 1 + k; --i) {
                temp += code[i];
            }
            res[0] = temp;
            for (int i = len - 1 + k; i > 0 - 1 + k; --i) {
                temp -= code[i - k];
                if (i < 0) {
                    temp += code[i + len];
                } else {
                    temp += code[i];
                }
                res[i - k] = temp;
            }
            return res;
        }

    }

     public static void main(String[] args) {
     }
}
