package com.learning.dsa_backend_app.codes.sorting.algorithms;

import java.util.Arrays;

public class SelectionSort {

	public int[] selectionSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int minInd = select(nums, i);
			swap(nums, i, minInd);
		}
		return nums;
	}

	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	int select(int[] nums, int startInd) {
		int minInd = startInd;
		for (int i = startInd + 1; i < nums.length; i++) {
			if (nums[i] < nums[minInd]) {
				minInd = i;
			}
		}
		return minInd;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 9, 11, 8, 6 };
		SelectionSort obj = new SelectionSort();
		System.out.println(Arrays.toString(obj.selectionSort(arr)));
	}

}
