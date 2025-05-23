package com.mydp.firstVideo;

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 15, 20 };
		// System.out.println(minCostClimbingStairs(arr, 1));
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
		System.out.println(helper(arr, dp));

	}

	public static int helper(int[] arr, int[] dp) {

		int a = minCostClimbingStairs(arr, 0, dp);
		int b = minCostClimbingStairs(arr, 1, dp);

		return Math.min(a, b);

	}

	public static int minCostClimbingStairs(int[] cost, int i, int[] dp) {

		if (i >= cost.length) {
			return 0;
		}

		if (dp[i] != -1) {
			return dp[i];
		}

		int a = minCostClimbingStairs(cost, i + 1, dp);
		int b = minCostClimbingStairs(cost, i + 2, dp);

		return dp[i] = Math.min(a, b) + cost[i];

	}

}
