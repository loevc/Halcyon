package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q78 {

    class Solution {
        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> path = new ArrayList<>();
            dfs(nums, 0, path);
            return ans;
        }

        private void dfs(int[] nums, int start, List<Integer> path) {
            ans.add(new ArrayList(path));
            for (int i = start; i < nums.length; ++i) {
                path.add(nums[i]);
                dfs(nums, i + 1, path);
                path.remove(path.size() - 1);
            }

        }
    }

     public static void main(String[] args) {
     }
}
