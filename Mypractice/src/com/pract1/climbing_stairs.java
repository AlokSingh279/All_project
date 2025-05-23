package com.pract1;

public class climbing_stairs {

	public static void main(String[] args) {

		int[] arr = { 10, 15, 20 };// 15
		System.out.println(stairs(arr, 1));

	}

	public static int stairs(int[] arr, int i) {
		if (i >= arr.length) {
			return 0;
		}

		int first = stairs(arr, i + 1);
		int second = stairs(arr, i + 2);

		return Math.min(first, second) + arr[i];
	}
}
