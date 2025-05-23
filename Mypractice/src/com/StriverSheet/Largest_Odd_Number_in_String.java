package com.StriverSheet;

public class Largest_Odd_Number_in_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String largestOddNumber(String num) {

		int n = num.length() - 1;

		while (n >= 0) {

			int number = num.charAt(n) - '0';
			{
				if (number % 2 != 0) {
					return num.substring(0, n + 1);

				}
				n--;
			}
		}
		return "";
	}
}
