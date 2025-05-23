package com.twod.Array;

import java.util.Scanner;

public class Spiral_print_matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//
//		int[][] arr = new int[n][m];
//		for (int i = 0; i < arr.length; i++) {
//
//			for (int j = 0; j < arr[0].length; j++) {
//
//				arr[i][j] = sc.nextInt();
//			}
//		}

		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printspiral(arr);

	}

	public static void printspiral(int[][] arr) {  //square matrix pe chalega spiral print but rectangle
	//	pe prblm karega slight change hai jo while loop hai usse har for loop me check karna hai bas
		

		int minr = 0;
		int maxr = arr.length - 1;
		int minc = 0;
		int maxc = arr[0].length - 1;
		int count = 0;
		int total = arr.length * arr[0].length;

		while (count < total) {
			for (int i = minc; i <= maxc; i++) {
				System.out.print(arr[minr][i] + " ");
				count++;
			}
			minr++;

			for (int i = minr; i <= maxr; i++) {
				System.out.print(arr[i][maxc] + " ");
				count++;
			}
			maxc--;

			for (int i = maxc; i >= minc; i--) {
				System.out.print(arr[maxr][i] + " ");
				count++;
			}
			maxr--;

			for (int i = maxr; i >= minr; i--) {
				System.out.print(arr[i][minc] + " ");
				count++;
			}
			minc++;
		}
	}

}
