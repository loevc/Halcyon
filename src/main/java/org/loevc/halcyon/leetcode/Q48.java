package org.loevc.halcyon.leetcode;

public class Q48 {

    class Solution {
        public void rotate(int[][] matrix) {
            // 顺时针90: 转置 ， 行反转
            // 逆时针90：转置，  列反转
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i >= j)
                        continue;
                    matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                    matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                    matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                }
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n / 2; ++j) {
                    matrix[i][j] = matrix[i][j] ^ matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = matrix[i][j] ^ matrix[i][n - 1 - j];
                    matrix[i][j] = matrix[i][j] ^ matrix[i][n - 1 - j];
                }
            }
        }
    }

     public static void main(String[] args) {
        new Q48().new Solution().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
     }
}
