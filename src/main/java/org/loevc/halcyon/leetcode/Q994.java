package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q994 {

    class Solution {
        private final int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int fresh = 0;
            List<int[]> q = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 1)
                        fresh++;
                    else if (grid[i][j] == 2) {
                        q.add(new int[] { i, j });
                    }
                }
            }

            int ans = 0;
            while (fresh > 0 && !q.isEmpty()) {
                ans++;
                List<int[]> temp = q;
                q = new ArrayList<>();
                for (int[] bad : temp) {
                    for (int[] direction : DIRECTIONS) {
                        int i = bad[0] + direction[0];
                        int j = bad[1] + direction[1];
                        if (i >= 0 && i < m && j >= 0 && j < n) {
                            if (grid[i][j] == 1) {
                                grid[i][j] = 2;
                                q.add(new int[] { i, j });
                                fresh--;
                            }
                        }
                    }
                }
            }
            return fresh > 0 ? -1 : ans;
        }
    }

     public static void main(String[] args) {
     }
}
