package org.loevc.halcyon.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Q15 {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Set<List<Integer>> resSets = new HashSet<>();
            for (int i = 0; i < nums.length; ++i) {
                int target = 0 - nums[i];
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = i + 1; j < nums.length; ++j) {
                    if (map.containsKey(target - nums[j])) {

                        int[] temp = new int[3];
                        temp[0] = nums[i];
                        temp[1] = nums[j];
                        temp[2] = target - nums[j];
                        Arrays.sort(temp);
                        resSets.add(new ArrayList<>(Arrays.asList(temp[0], temp[1], temp[2])));


                        continue;
                    } else {
                        map.put(nums[j], j);
                    }
                }
            }
            res = new ArrayList<>();
            for (List<Integer> sets : resSets) {
                res.add(sets);
            }
            return res;
        }

        // private List<List<Integer>> twoSum(int[] nums)
    }

    public static void main(String[] args) {
    }
}
