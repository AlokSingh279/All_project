package com.binarytree;

public class Diameter_of_binary_tree {

	public class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Solution {
		public int diameterOfBinaryTree(TreeNode root) {

			if (root == null) {
				return 0;
			}

			int ld = diameterOfBinaryTree(root.left);
			int rd = diameterOfBinaryTree(root.right);

			int sd = height(root.left) + height(root.right) + 2;
			return Math.max(ld, Math.max(rd, sd));
		}

		public int height(TreeNode nn) {

			if (nn == null) {
				return -1;
			}

			int lh = height(nn.left);
			int rh = height(nn.right);

			return Math.max(lh, rh) + 1;
		}
	}
}
