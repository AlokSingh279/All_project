package com.pract1;

import java.util.HashMap;
import java.util.Map;

public class Min_deletion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";// 1
		int k = 2;
		System.out.println(minDeletion(s, k));

	}

	public static int minDeletion(String s, int k) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int sum = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			while (entry.getKey() > k) {
				sum = sum + entry.getValue();
			}
			// Integer value = entry.getValue();
			// System.out.println("Key: " + key + ", Value: " + value);
		}
		return sum;

	}

}
