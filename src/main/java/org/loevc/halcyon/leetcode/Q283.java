package org.loevc.halcyon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q283 {

    class Solution {
        public void moveZeroes(int[] nums) {
            int zeroIndex = -1;
            int cur = 0;
            List<Integer> list = new ArrayList<>();
            while (cur < nums.length) {
                if (nums[cur] == 0) {
                    list.add(cur);
                    ++cur;
                } else {
                    if (zeroIndex == -1) {
                        ++cur;
                        continue;
                    } else {
                        nums[zeroIndex] = nums[cur];
                        nums[cur] = 0;
                        if (!list.isEmpty()) {
                            zeroIndex = list.remove(0);
                        } else {
                            zeroIndex = -1;
                        }
                    }
                }
                if (zeroIndex == -1 && !list.isEmpty()) {
                    zeroIndex = list.remove(0);
                }
            }
        }
    }

     public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
         System.out.println(list.remove(0));
         System.out.println(list.remove(0));

//         int[] nums = {0, 1, 0, 3, 12};
         int[] nums = {1};
         new Q283().new Solution().moveZeroes(nums);
         System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
     }
}
