package com.learning.dsa_backend_app.codes.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 1, 3, 2, 2 };
		MajorityElementII obj = new MajorityElementII();
		System.out.println(obj.majorityElementTwo(arr));
	}

	public List<Integer> majorityElementTwo(int[] nums) {
		List<Integer> ans = new ArrayList<>();

		int count1 = 0, count2 = 0, n = nums.length;
		int ele1 = Integer.MAX_VALUE, ele2 = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {

			if (count1 == 0 && nums[i] != ele2) {
				ele1 = nums[i];
				count1 = 1;
			} else if (count2 == 0 && nums[i] != ele1) {
				ele2 = nums[i];
				count2 = 1;
			} else if (ele1 == nums[i]) {
				count1++;
			} else if (ele2 == nums[i]) {
				count2++;
			} else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == ele1) {
				count1++;
			} else if (nums[i] == ele2) {
				count2++;
			}
		}
		if (count1 > n / 3) {
			ans.add(ele1);
		}
		if (count2 > n / 3) {
			ans.add(ele2);
		}
		return ans;
	}

}
