package org.loevc.halcyon.leetcode;

public class Q42 {

    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int[] sufMax = new int[n];
            int[] preMax = new int[n];
            sufMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                sufMax[i] = Math.max(sufMax[i + 1], height[i]);
            }
            preMax[0] = height[0];
            for (int i = 1; i < n; ++i) {
                preMax[i] = Math.max(preMax[i - 1], height[i]);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += Math.min(preMax[i], sufMax[i]) - height[i];
            }
            return ans;
        }
    }

     public static void main(String[] args) {
        new Q42().new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
     }
}
