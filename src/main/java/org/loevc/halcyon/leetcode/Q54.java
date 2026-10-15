package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q54 {

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int u = 0;
            int l = 0;
            int d = matrix.length - 1;
            int r = matrix[0].length - 1;
            List<Integer> res = new ArrayList<>();
            int cnt = (d + 1) * (r + 1);
            while (l <= r && u <= d) {
                for (int i = l; i <= r; ++i) {
                    res.add(matrix[u][i]);
                    cnt--;
                    if (cnt == 0)
                        return res;
                }
                u++;
                for (int i = u; i <= d; ++i) {
                    res.add(matrix[i][r]);
                    cnt--;
                    if (cnt == 0)
                        return res;
                }
                r--;
                for (int i = r; i >= l; --i) {
                    res.add(matrix[d][i]);
                    cnt--;
                    if (cnt == 0)
                        return res;
                }
                d--;
                for (int i = d; i >= u; --i) {
                    res.add(matrix[i][l]);
                    cnt--;
                    if (cnt == 0)
                        return res;
                }
                l++;

            }
            return res;
        }
    }

     public static void main(String[] args) {
//         System.out.println(new Q54().new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
         System.out.println(new Q54().new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
     }
}
