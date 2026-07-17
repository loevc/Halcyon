package org.loevc.halcyon.leetcode;

public class Q33 {

    class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            int left = 0;
            int right = len -1 ;
            int  mid = left + (right-left)/2;
            while (true){

                mid = left + (right-left)/2;
                if (nums[mid] == target) return mid;
                if (nums[left] == target) return left;
                if (nums[right] == target) return right;
                if ((left + 1) >= right) break ;
                if (nums[mid] < nums[left] && nums[mid] < nums[right]) break;

                if (nums[mid] < nums[left]) {
                    right = mid;

                } else {
                    left = mid;
                }
            }

            if (target > nums[len -1]){
                left = 0;
                right = mid -1;
            } else {
                left = mid ;
                right = len -1;
            }

            while (true){
                mid = left + (right-left)/2;
                if (left >= right) return -1 ;
                if (nums[mid] == target) return mid;
                if (nums[left] == target) return left;
                if (nums[right] == target) return right;
                if (target < nums[mid]) {
                    right = mid;

                } else {
                    left = mid;
                }
            }
        }


        private int findMin(int[] nums){
            int len = nums.length;
            int left = 0;
            int right = len - 1;
            int mid = (left + right) /2;
            while ( (left + 1) < right){
                if ((nums[mid] >= nums[left]) && (nums[mid] >= nums[right])){
                    left = mid;
                } else if ((nums[mid] <= nums[left]) && (nums[mid] <= nums[right])) {
                    right = mid;
                }
                mid = (left + right) /2;

            }
            return nums[mid];

        }

        private int findMin2(int[] nums){
            int len = nums.length;
            int left = 0;
            int right = len - 1;
            int mid = (left + right) /2;
            while ( (left + 1) < right){
                if (nums[mid] > nums[right]){
                    left = mid;
                } else  {
                    right = mid;
                }
                mid = (left + right) /2;

            }
            return Math.min(nums[left], nums[right]);

        }
    }

         public static void main(String[] args) {
             Solution solution = new Q33().new Solution();
//             int[] nums = {4,5,6,7,0,1,2};
//             int target = 3;

//             int[] nums = {1};
//             int target = 0;

//             int[] nums = {1};
//             int target = 1;

//            int[] nums = {1,3};
//             int target = 0;
//
//             System.out.println(solution.search(nums, target));
             System.out.println(solution.findMin2(new int[]{ 1}));
         }




}
