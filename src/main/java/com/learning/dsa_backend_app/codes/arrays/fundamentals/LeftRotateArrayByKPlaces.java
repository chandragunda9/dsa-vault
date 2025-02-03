package com.learning.dsa_backend_app.codes.arrays.fundamentals;

public class LeftRotateArrayByKPlaces {
    public void rotateArray1(int[] nums, int d) {
        int n = nums.length;
        d = d % n;
        //method1
        int[] temp = new int[d];
        //copy the first k elements
        for (int i = 0; i < d; i++) {
            temp[i] = nums[i];
        }
        //shifting elements
        for (int i = d; i < n; i++) {
            nums[i - d] = nums[i];
        }
        //copy back elements from temp
        for (int i = 0; i < d; i++) {
            nums[n - d + i] = temp[i];
        }
    }

    void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    //method2
    public void rotateArray2(int[] nums, int d) {
        d = d % nums.length;
        //reverse 0 to k-1
        reverse(nums, 0, d - 1);
        //reverse k to n-1
        reverse(nums, d, nums.length - 1);
        //reverse entire array
        reverse(nums, 0, nums.length - 1);
    }

    //method3: Using Juggling algorithm
    public void rotateArray3(int[] nums, int d) {
        int n = nums.length;
        d = d % n;
        int gcd = findGcd(n, d);
        for (int i = 0; i < gcd; i++) {
            int temp = nums[i];
            int j = i, k;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                nums[j] = nums[k];
                j = k;
            }
            nums[j] = temp;
        }
    }

    int findGcd(int n1, int n2) {
        while (n1 > 0 && n2 > 0) {
            if (n1 > n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }
        if (n1 == 0)
            return n2;
        return n1;
    }
}