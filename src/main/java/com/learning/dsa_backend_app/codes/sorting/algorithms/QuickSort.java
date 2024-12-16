package com.learning.dsa_backend_app.codes.sorting.algorithms;

import java.util.Arrays;

public class QuickSort {

	public static int[] quickSort(int[] nums) {
		sort(nums, 0, nums.length - 1);
		return nums;
	}

	static int partition(int[] nums, int low, int high) {
		int pivot = nums[low];
		int i = low, j = high;
		while (i < j) {
			while (i <= high && nums[i] <= pivot) {
				i++;
			}
			while (j >= low && nums[j] > pivot) {
				j--;
			}
			if (i < j) {
				swap(nums, i, j);
			}
		}
		swap(nums, low, j);
		return j;
	}

	static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	static void sort(int[] nums, int l, int r) {
		if (l < r) {
			int pi = partition(nums, l, r);
			sort(nums, l, pi - 1);
			sort(nums, pi + 1, r);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 9, 11, 8, 6 };
		System.out.println(Arrays.toString(quickSort(arr)));
	}
}
