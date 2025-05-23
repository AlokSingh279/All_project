package com.twod.Array;

import java.util.Scanner;

public class Stair_case_search {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] arr = new int[n][m];
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[0].length; j++) {

				arr[i][j] = sc.nextInt();
			}
		}
		int x = sc.nextInt();
		System.out.println(serach_Matrix(arr, x));
	}

	public static int serach_Matrix(int[][] arr, int x) {// sorted matrix o(n)

		int row = 0;

		int col = arr[0].length - 1;

		while (row < arr.length && col >= 0) {

			if (arr[row][col] == x) {
				return 1;
			} else if (arr[row][col] < x) {
				row++;
			} else {
				col--;
			}
		}
		return 0;
	}
}
