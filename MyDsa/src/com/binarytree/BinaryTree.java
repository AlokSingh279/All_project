package com.binarytree;

import java.util.Scanner;

public class BinaryTree {

	Scanner sc = new Scanner(System.in);

	public class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		this.root = createTree();
	}

	private Node createTree() {
		int item = sc.nextInt();
		Node nn = new Node();
		nn.data = item;

		boolean lt = sc.nextBoolean();
		if (lt == true) {
			nn.left = createTree();
		}

		boolean rt = sc.nextBoolean();
		if (rt == true) {
			nn.right = createTree();
		}
		return nn;
	}

	public void Display() {
		display(this.root);
	}

	private void display(Node nn) {
		if (nn == null) {
			return;
		}

		String str = "";
		// System.out.println(str + nn.data);
		str = str + nn.data;
		str = "<--" + str + "-->";
		if (nn.left != null) {
			str = nn.left.data + str;
		} else {
			str = "." + str;
		}

		if (nn.right != null) {
			str = str + nn.right.data;
		} else {
			str = str + ".";
		}

		System.out.println(str);
		display(nn.left);
		display(nn.right);

	}

	public int height() {
		return height(this.root);
	}

	private int height(Node nn) {

		if (nn == null) {
			return -1;
		}

		int lh = height(nn.left);
		int rh = height(nn.right);

		return Math.max(lh, rh) + 1;
	}
}
