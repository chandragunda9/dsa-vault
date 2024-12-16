package com.learning.dsa_backend_app.codes.sorting.algorithms;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 9, 11, 8, 6 };
		MergeSort obj = new MergeSort();
		System.out.println(Arrays.toString(obj.mergeSort(arr)));
	}

	public int[] mergeSort(int[] nums) {
		sort(nums, 0, nums.length - 1);
		return nums;
	}

	void merge(int[] nums, int l, int m, int r) {
		int n1 = m - l + 1, n2 = r - m;
		int[] lhalf = new int[n1], rhalf = new int[n2];
		for (int i = 0; i < n1; i++) {
			lhalf[i] = nums[l + i];
		}
		for (int i = 0; i < n2; i++) {
			rhalf[i] = nums[m + 1 + i];
		}

		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (lhalf[i] <= rhalf[j]) {
				nums[k++] = lhalf[i++];
			} else {
				nums[k++] = rhalf[j++];
			}
		}
		while (i < n1) {
			nums[k++] = lhalf[i++];
		}
		while (j < n2) {
			nums[k++] = rhalf[j++];
		}
	}

	void sort(int[] nums, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(nums, l, m);
			sort(nums, m + 1, r);
			merge(nums, l, m, r);
		}
	}
}
