package com.learning.dsa_backend_app.codes.arrays.fundamentals;

public class LeftRotateArrayByOne {
    public void rotateArrayByOne(int[] nums) {
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = temp;
    }
}
