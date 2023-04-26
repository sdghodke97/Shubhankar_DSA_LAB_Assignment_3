package com.gl.lab3;
import java.util.*;

class Node {
	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static List<Integer[]> checkTarget(TreeNode root, int targetSum) {
		Set<Integer> set = new HashSet<>();
		List<Integer[]> sumPairs = new ArrayList<>();
		return findPair(root, set, targetSum, sumPairs);
	}

	public static List<Integer[]> findPair(TreeNode root, Set<Integer> set, int targetSum, List<Integer[]> sumPairs) {
		if (root == null) {
			return sumPairs;
		}
		if (set.contains(targetSum - root.data)) {
			sumPairs.add(new Integer[] { root.data, targetSum - root.data });
		}
		set.add(root.data);
		findPair(root.left, set, targetSum, sumPairs);
		findPair(root.right, set, targetSum, sumPairs);
		return sumPairs;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(20);
		root.right = new TreeNode(60);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(30);
		root.right.left = new TreeNode(50);
		root.right.right = new TreeNode(70);
		int targetSum = 130;
		List<Integer[]> sumPairs = checkTarget(root, targetSum);
		if (sumPairs.isEmpty()) {
			System.out.println("Pairs are not found");
		} else {
			System.out.println("Pairs of sum " + targetSum + " is");
			for (int i = 0; i < sumPairs.size(); i++) {
				Integer[] pair = sumPairs.get(i);
				System.out.println("(" + pair[1] + ", " + pair[0] + ")");
			}

		}
	}
}