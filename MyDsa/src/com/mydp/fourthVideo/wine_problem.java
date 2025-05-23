package com.mydp.fourthVideo;

import java.util.Arrays;

public class wine_problem {

	// isme har element ko uske index ke saath *
//	karna hai baki recursion ko bhej dena hai * ke baad sabhi element ko + karte 
//	jana hai ye same chiz last index se bhi karna hai for better possibilities dono ka max
//	leke return karna hai
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 3, 5, 1, 4 };
		int[][] dp = new int[nums.length][nums.length];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		System.out.println(wineproblem(nums, 0, nums.length - 1, 1, dp));

	}

	public static int wineproblem(int[] nums, int i, int j, int year, int[][] dp) {

		if (i > j) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int left = nums[i] * year + wineproblem(nums, i + 1, j, year + 1, dp);// year extra liye index se bhi maintain
																				// kar sakte hai
		int right = nums[j] * year + wineproblem(nums, i, j - 1, year + 1, dp);

		return dp[i][j] = Math.max(left, right);

	}
}
