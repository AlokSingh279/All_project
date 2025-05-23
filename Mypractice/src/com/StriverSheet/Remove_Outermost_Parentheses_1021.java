package com.StriverSheet;

import java.util.Stack;

public class Remove_Outermost_Parentheses_1021 {

	public static void main(String[] args) {

	}

	public static String removeOuterParentheses(String s) {

		Stack<Character> st = new Stack();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == '(') {
				if (st.size() > 0) {
					sb.append(ch);
				}
				st.push(ch);
			}

			else {
				st.pop();
				if (st.size() > 0) {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}
}
