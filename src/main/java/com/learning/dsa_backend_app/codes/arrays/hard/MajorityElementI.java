package com.learning.dsa_backend_app.codes.arrays.hard;

public class MajorityElementI {

	public static void main(String[] args) {
		int[] arr = { 7, 0, 0, 1, 7, 7, 2, 7, 7 };
		MajorityElementI obj = new MajorityElementI();
		System.out.println(obj.majorityElement(arr));
	}

	public int majorityElement(int[] nums) {
		int ele = -1, count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				ele = nums[i];
				count = 1;
			} else if (nums[i] == ele) {
				count++;
			} else {
				count--;
			}
		}

		return ele;
	}

}
