package com.mydp.fifthVideo;

public class Mcm { // matrix multiplication

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 2, 3, 5, 1 };// output 29
		System.out.println(mcm(nums, 0, nums.length - 1));// revision needed one more time

	}

	public static int mcm(int[] arr, int i, int j) {

		if (i + 1 == j) {
			return 0;
		}

		int ans = Integer.MAX_VALUE;

		for (int k = i + 1; k < j; k++) {

			int fs = mcm(arr, i, k);
			int ls = mcm(arr, k, j);
			int ss = arr[i] * arr[k] * arr[j];

			ans = Math.min(ans, fs + ls + ss);
		}
		return ans;

	}

}
