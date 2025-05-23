package com.twod.Array;

public class spiral_print_generalized {

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

		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 13, 14, 15, 16 } };
		printspiral(arr);

	}

	public static void printspiral(int[][] arr) { // generalized hai sab pe chalega

		int minr = 0;
		int maxr = arr.length - 1;
		int minc = 0;
		int maxc = arr[0].length - 1;
		int count = 0;
		int total = arr.length * arr[0].length;

		while (count < total) {
			for (int i = minc; i <= maxc && count < total; i++) {
				System.out.print(arr[minr][i] + " ");
				count++;
			}
			minr++;

			for (int i = minr; i <= maxr && count < total; i++) {
				System.out.print(arr[i][maxc] + " ");
				count++;
			}
			maxc--;

			for (int i = maxc; i >= minc && count < total; i--) {
				System.out.print(arr[maxr][i] + " ");
				count++;
			}
			maxr--;

			for (int i = maxr; i >= minr && count < total; i--) {
				System.out.print(arr[i][minc] + " ");
				count++;
			}
			minc++;
		}
	}

}
