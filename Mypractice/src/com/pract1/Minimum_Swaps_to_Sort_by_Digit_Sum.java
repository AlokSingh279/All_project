package com.pract1;

public class Minimum_Swaps_to_Sort_by_Digit_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 18, 43, 34, 16 };// output 1
		System.out.println(minSwaps(nums));

	}

	public static int minSwaps(int[] nums) {

		int[] ans = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			ans[i] = helper(n);
		} // 10,1 4,5,6,7

		int i = 0;
		int j = ans.length - 1;

		int count = 0;

		while (i < j) {

			if (ans[i] > ans[j]) {
				count++;
			}
			i++;
			j--;
		}
		return count;

	}

	public static int helper(int n) {

		int sum = 0;
		while (n > 0) {
			int div = n % 10;
			sum = sum + div;
			n = n / 10;
		}
		return sum;
	}
}
