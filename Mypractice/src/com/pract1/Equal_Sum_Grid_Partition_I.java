package com.pract1;

public class Equal_Sum_Grid_Partition_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 5,4,7,5,6 }, { 5,4,7,5,6} }; // output =true
		System.out.println(canPartitionGrid(grid));

	}

	public static boolean canPartitionGrid(int[][] grid) {

		int count = 0;
		for (int i = 0; i < grid.length; i++) {

			int sum = 0;
			for (int j = 0; j < grid[0].length; j++) {

				sum = sum + grid[i][j];
			}

			if (i == 0) {
				count = sum;
			} else {
				if (count == sum) {
					return true;
				}
			}

		}
		return false;
	}

}
