package com.mydp.firstVideo;

import java.util.Arrays;

public class House_robber {

	public static void main(String[] args) {// top down

		int[] nums = { 1, 2, 3, 1 };
		//int[] dp = new int[nums.length];
//		Arrays.fill(dp, -1);
//		System.out.println(rob(nums, 0, dp));
		System.out.println(helper(nums));

	}

	public static int helper(int[] nums) {

		int n = nums.length;

		int[] dp1 = new int[n];
		Arrays.fill(dp1, -1);

		int[] dp2 = new int[n];
		Arrays.fill(dp2, -1);

		int a = rob(nums, 0, n - 2, dp1);
		int b = rob(nums, 1, n - 1, dp2);

		return Math.max(a, b);
	}

	public static int rob(int[] nums, int i, int end, int[] dp) {//both house robber and house robber2

		if (i > end) {
			return 0;
		}

		if (dp[i] != -1) {
			return dp[i];
		}

		int rob1 = nums[i] + rob(nums, i + 2, end, dp);
		int rob2 = rob(nums, i + 1, end, dp);

		return dp[i] = Math.max(rob1, rob2);

	}
}
