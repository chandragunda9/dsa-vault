package com.learning.dsa_backend_app.codes.arrays.fundamentals;

public class MaximumElement {
    public int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
