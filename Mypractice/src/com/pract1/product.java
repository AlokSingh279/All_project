package com.pract1;

public class product {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 124; // output 3 3*1=3
		System.out.println(maxmproduct(n));

	}

	public static int maxmproduct(int n) {

		int max = 0;

		String string = String.valueOf(n);

		for (int i = 0; i < string.length()-1; i++) {

			int j = i + 1;

			 int product = (string.charAt(i) - '0') * (string.charAt(j) - '0');
			    max = Math.max(max, product);

		}
		return max;

	}

}
