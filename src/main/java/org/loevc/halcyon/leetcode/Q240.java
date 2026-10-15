package org.loevc.halcyon.leetcode;

public class Q240 {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length - 1;
            int n = matrix[0].length - 1;
            int i = m;
            int j = 0;
            while (true) {
                if (matrix[i][j] > target) {
                    --i;
                } else if (matrix[i][j] < target) {
                    ++j;
                } else {
                    return true;
                }
                if (i < 0 || j > n)
                    return false;
            }

        }
    }

     public static void main(String[] args) {
//         System.out.println(new Q240().new Solution().searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
         System.out.println(new Q240().new Solution().searchMatrix(new int[][]{{-5}}, -5));
     }
}
