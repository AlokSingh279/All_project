package com.StriverSheet;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element_2 {

	public static void main(String[] args) {

	}

	public static int[] greater(int[] nums) {
		int n = nums.length;

		int[] nextGreater = new int[n];
		Arrays.fill(nextGreater, -1);

		Stack<Integer> s = new Stack<>();

		// first store all the elements in a monotonic(increasing) stack from last to
		// first
		for (int i = n - 1; i >= 0; i--) {
			if (!s.isEmpty() && s.peek() <= nums[i])
				s.pop();
			s.push(nums[i]);
		}

		// stack is precomputed storing elements from first to last in increasing order
		for (int i = n - 1; i >= 0; i--) {
			while (!s.isEmpty() && s.peek() <= nums[i])
				s.pop();
			if (!s.isEmpty())
				nextGreater[i] = s.peek();
			s.push(nums[i]);
		}

		return nextGreater;
	}

}
