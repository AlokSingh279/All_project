package com.mydp.fourthVideo;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		int[][] dp = new int[grid.length][grid[0].length];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		int sum = Integer.MAX_VALUE;
		for (int i = 0; i < grid[0].length; i++) {// sirf row ka min pucha hai question me isliye row ka ans nikal rahe
													// min leke
			sum = Math.min(sum, minFallingPathSummm(grid, 0, i, dp));
		}
		System.out.println(sum);

	}

	public static int minFallingPathSummm(int[][] grid, int i, int j, int[][] dp) {

		if (j < 0 || j >= grid[0].length) {// col bahar jaye toh matrix se uske liye
			return Integer.MAX_VALUE;
		}

		if (i == grid.length - 1) {// last row touch hotre hi ans lenge
			return grid[i][j];
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int left = minFallingPathSummm(grid, i + 1, j - 1, dp);
		int down = minFallingPathSummm(grid, i + 1, j, dp);
		int right = minFallingPathSummm(grid, i + 1, j + 1, dp);

		return dp[i][j] = grid[i][j] + Math.min(left, Math.min(down, right));

	}

}
