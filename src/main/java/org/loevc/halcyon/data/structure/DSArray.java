package org.loevc.halcyon.data.structure;

import java.util.concurrent.ThreadLocalRandom;

public class DSArray {

    private void opArray(){
        int[] arr = new int[5];
        int[] nums = {1, 3, 2, 5, 4};
    }


    private int randomAccess(int[] nums){
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
        return nums[randomIndex];
    }

     void insert(int[] nums, int num, int index){
        for (int i = nums.length - 1; i > index; --i) {
            nums[i] = nums[i - 1];
        }
        nums[index] = num;
     }

     void remove(int[] nums, int index){
        for (int i = index; i < nums.length -1; ++i) {
            nums[i] = nums[i + 1];
        }
     }

     void traverse(int[] nums){
        int count = 0;
         for (int i = 0; i < nums.length; i++) {
             count += nums[i];
         }

         for (int num : nums) {
             count += num;
         }
     }
}
