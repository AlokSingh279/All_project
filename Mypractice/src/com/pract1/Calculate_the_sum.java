package com.pract1;

import java.util.Scanner;

public class Calculate_the_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int t = sc.nextInt();
		while (t-- > 0) {
			int x = sc.nextInt();
			int[] brr = new int[n];
			for (int i = 0; i < arr.length; i++) {

				int j = i - x;
				if (j < 0) {
					j = j + n;
				}
				brr[i] = arr[i] + arr[j];
			}
			arr = brr;
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		System.out.println(sum);

	}

}

//5
//1 2 3 4 5     testcase
//2
//1
//0
//60
