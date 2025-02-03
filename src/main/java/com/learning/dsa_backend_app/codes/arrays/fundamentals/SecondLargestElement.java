package com.learning.dsa_backend_app.codes.arrays.fundamentals;

public class SecondLargestElement {
    public int secondLargestElement(int[] nums) {
        if (nums.length < 2)
            return -1;
        int largest = Integer.MIN_VALUE, sLargest = Integer.MIN_VALUE;
        for (int ele : nums) {
            if (ele > largest) {
                sLargest = largest;
                largest = ele;
            } else if (ele > sLargest && ele < largest) {
                sLargest = ele;
            }
        }
        return sLargest == Integer.MIN_VALUE ? -1 : sLargest;
    }
}
