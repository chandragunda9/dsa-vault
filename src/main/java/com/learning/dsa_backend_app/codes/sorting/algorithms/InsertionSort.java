package com.learning.dsa_backend_app.codes.sorting.algorithms;

import java.util.Arrays;

public class InsertionSort {

	public int[] insertionSort(int[] nums) {
		int n = nums.length;
		for (int i = 1; i < n; i++) {
			int j = i, ele = nums[j];

			while (j > 0 && nums[j - 1] > ele) {
				nums[j] = nums[j - 1];
				j = j - 1;
			}

			nums[j] = ele;
		}
		return nums;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 9, 11, 8, 6 };
		InsertionSort obj = new InsertionSort();
		System.out.println(Arrays.toString(obj.insertionSort(arr)));
	}

}
