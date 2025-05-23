package com.twod.Array;

import java.util.Scanner;

public class Jacked_Array {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] arr = new int[n][];
		for (int i = 0; i < arr.length; i++) {

			int c = sc.nextInt();
			arr[i] = new int[c];
			for (int j = 0; j < arr[i].length; j++) {

				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				System.out.print(arr[i][j] + " ");
			}
		}
	}
}
