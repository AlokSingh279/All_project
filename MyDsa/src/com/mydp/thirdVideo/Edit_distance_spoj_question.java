package com.mydp.thirdVideo;

import java.util.Arrays;

public class Edit_distance_spoj_question {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "FOOD";//string 1 me hi operation karna hai to make s2
		String s2 = "MONEY";
		int[][] dp = new int[s1.length()][s2.length()];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		System.out.println(Edit_distance(s1, s2, 0, 0, dp));

	}

	public static int Edit_distance(String s1, String s2, int i, int j, int[][] dp) {

		if (i == s1.length()) {
			return s2.length() - j;// s2 ki length add kar denge remaining wale
		}

		if (j == s2.length()) {
			return s1.length() - i;// s1 ki length add karenge as above
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int ans = 0;

		if (s1.charAt(i) == s2.charAt(j)) {
			ans = Edit_distance(s1, s2, i + 1, j + 1, dp);
		} else {
			int delete = Edit_distance(s1, s2, i + 1, j, dp);
			int insert = Edit_distance(s1, s2, i, j + 1, dp);
			int replace = Edit_distance(s1, s2, i + 1, j + 1, dp);
			ans = Math.min(delete, Math.min(insert, replace)) + 1;// +1 islie kyuki har test cases par 1 add karna tha
																	// ques me
		}

		return dp[i][j] = ans;
	}

}
