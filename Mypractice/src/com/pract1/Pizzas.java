package com.pract1;

import java.util.Arrays;

public class Pizzas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(maxWeight(arr));

	}

	public static long maxWeight(int[] pizzas) {
		Arrays.sort(pizzas);
		int n = pizzas.length, days = n / 4;
		long totalWeight = 0;
		int index = n - 1;

		// Pick heaviest pizza on odd days
		for (int day = 1; day <= days; day += 2) {
			totalWeight += pizzas[index--];
		}

		// Pick second heaviest pizza on even days
		index--;
		for (int day = 2; day <= days; day += 2) {
			totalWeight += pizzas[index];
			index -= 2;
		}
		return totalWeight;
	}
}
