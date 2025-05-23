package com.mydp.thirdVideo;

import java.util.Arrays;

public class Lcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "abcde", text2 = "ace";
		int[][] dp = new int[text1.length()][text2.length()];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		System.out.println(longestCommonSubsequence(text1, text2, 0, 0, dp));
	}

	public static int longestCommonSubsequence(String text1, String text2, int i, int j, int[][] dp) {
		int ans = 0;
		if (i == text1.length()) {
			return 0;
		}

		if (j == text2.length()) {
			return 0;
		}
		
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}

		int inc = 0;
		int exc = 0;

		if (text1.charAt(i) == text2.charAt(j)) {
			ans = 1 + longestCommonSubsequence(text1, text2, i + 1, j + 1, dp);
		}

		inc = longestCommonSubsequence(text1, text2, i + 1, j, dp);
		exc = longestCommonSubsequence(text1, text2, i, j + 1, dp);

		return dp[i][j]=Math.max(ans, Math.max(inc, exc));
	}

}
