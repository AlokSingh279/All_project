package com.StriverSheet;

public class Single_Element_in_a_Sorted_Array {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		System.out.println(singleNonDuplicate(arr));
	}

	public static int singleNonDuplicate(int[] nums) {

		int n = nums.length;

		if (nums[0] != nums[1]) {

			return nums[0];
		}
		if (nums[n - 1] != nums[n - 2]) {

			return nums[n - 1];
		}

		int left = 0, right = nums.length - 1;

		while (left <= right) {

			int mid = left + (right - left) / 2;

			if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
				return nums[mid];
			} else if (nums[mid] == nums[mid - 1]) {
				int lc = mid - left + 1;
				if (lc % 2 == 0) {
					left = mid + 1;
				} else {
					right = mid - 2;
				}
			} else if (nums[mid] == nums[mid + 1]) {
				int rc = right - mid + 1;
				if (rc % 2 == 0) {
					right = mid - 1;
				} else {
					left = mid + 2;
				}
			}
		}
		return -1;
	}

}
