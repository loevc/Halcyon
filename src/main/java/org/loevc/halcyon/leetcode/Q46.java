package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q46 {

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            int[] state = new int[nums.length];
            List list = new ArrayList<>();
            dfs(nums, state, list);
            return ans;
        }

        private void dfs(int[] nums, int[] state, List<Integer> path) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList(path));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {

                if (state[i] == 1) {
                    continue;
                }
                path.add(nums[i]);
                state[i] = 1;
                dfs(nums, state, path);
                state[i] = 0;
                path.remove(path.size() - 1);
            }

        }
    }

     public static void main(String[] args) {
     }
}
