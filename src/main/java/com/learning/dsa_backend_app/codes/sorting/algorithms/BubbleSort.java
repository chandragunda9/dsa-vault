package com.learning.dsa_backend_app.codes.sorting.algorithms;

import java.util.Arrays;

public class BubbleSort {

	public int[] bubbleSort(int[] nums) {
		int n = nums.length;
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (nums[j + 1] < nums[j]) {
					int t = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = t;
				}
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 9, 11, 8, 6 };
		BubbleSort obj = new BubbleSort();
		System.out.println(Arrays.toString(obj.bubbleSort(arr)));
	}

}
