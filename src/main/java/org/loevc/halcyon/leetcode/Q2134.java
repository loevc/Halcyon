package org.loevc.halcyon.leetcode;

public class Q2134 {

    class Solution {
        public int minSwaps(int[] nums) {
            int zeroCnt = 0;
            int oneCnt = 0;
            for (int num : nums) {
                if (num == 0)
                    ++zeroCnt;
                else {
                    ++oneCnt;
                }
            }

            // 我在上面取到了1 的总数， 不应该纠结把两个循环合并为1个
            // 罚时 15分钟

            // 找到区间最大连续的1 或者 0
            // 分别对1 和 0 滑动窗口
            // zeroCnt - zeroMax 和 oneCnt - oneMax 取最小值

            int zeroMax = 0;
            int oneMax = 0;
            zeroMax = maxWindows(nums, zeroCnt, 0);
            oneMax = maxWindows(nums, oneCnt, 1);
            return Math.min((zeroCnt - zeroMax), (oneCnt - oneMax));

        }

        private int maxWindows(int[] nums, int k, int target) {
            int res = 0;
            int temp = 0;
            for (int i = 0; i < k; ++i) {
                if (nums[i] == target) {
                    ++temp;
                }
            }
            res = Math.max(temp, res);

            for (int i = k; i < nums.length; ++i) {
                if (nums[i - k] == target)
                    --temp;

                if (nums[i] == target)
                    ++temp;
                res = Math.max(temp, res);
            }

            return res;
        }
    }

     public static void main(String[] args) {
     }
}
