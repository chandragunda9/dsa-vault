package com.learning.dsa_backend_app.codes.arrays.fundamentals;

public class LinearSearch {
    public int linearSearch(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target)
                return i;
        }
        return -1;
    }
}
