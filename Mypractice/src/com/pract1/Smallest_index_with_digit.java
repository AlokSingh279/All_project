package com.pract1;

public class Smallest_index_with_digit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1,2,3 };// output 2
		System.out.println(smallestIndex(nums));

	}

	public static int smallestIndex(int[] nums) {

		for (int i = 0; i < nums.length; i++) {

			int n = nums[i];
			if (helper(n) == i) {

				return i;
			}

		}
		return -1;

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
