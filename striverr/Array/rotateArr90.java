/*
LeetCode 48 - Rotate Image (Problem Statement)

Given an n x n 2D matrix representing an image, rotate the image by 90 degrees clockwise.

Important condition:
- You must rotate the matrix in-place, meaning you cannot use another n x n matrix.

Example 1:
Input:
1 2 3
4 5 6
7 8 9

Output:
7 4 1
8 5 2
9 6 3

Example 2:
Input:
5  1  9 11
2  4  8 10
13 3  6  7
15 14 12 16

Output:
15 13 2  5
14 3  4  1
12 6  8  9
16 7  10 11
*/

class Solution {
	public void rotate(int[][] matrix) {
		int n = matrix.length;

		// Transpose the matrix
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// Reverse each row
		for (int i = 0; i < n; i++) {
			int left = 0;
			int right = n - 1;
			while (left < right) {
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
				left++;
				right--;
			}
		}
	}
}

public class rotateArr90 {

	private static int[][] deepCopy(int[][] matrix) {
		int[][] copy = new int[matrix.length][];
		for (int i = 0; i < matrix.length; i++) {
			copy[i] = matrix[i].clone();
		}
		return copy;
	}

	private static boolean matricesEqual(int[][] a, int[][] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i].length != b[i].length) {
				return false;
			}
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	private static void runTest(String testName, int[][] input, int[][] expected) {
		Solution solution = new Solution();
		int[][] actual = deepCopy(input);
		solution.rotate(actual);

		System.out.println("---- " + testName + " ----");
		System.out.println("Input:");
		printMatrix(input);
		System.out.println("Output:");
		printMatrix(actual);
		System.out.println("Expected:");
		printMatrix(expected);

		if (matricesEqual(actual, expected)) {
			System.out.println("Result: PASS\n");
		} else {
			System.out.println("Result: FAIL\n");
		}
	}

	public static void main(String[] args) {
		int[][] test1 = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		int[][] expected1 = {
			{7, 4, 1},
			{8, 5, 2},
			{9, 6, 3}
		};

		int[][] test2 = {
			{5, 1, 9, 11},
			{2, 4, 8, 10},
			{13, 3, 6, 7},
			{15, 14, 12, 16}
		};
		int[][] expected2 = {
			{15, 13, 2, 5},
			{14, 3, 4, 1},
			{12, 6, 8, 9},
			{16, 7, 10, 11}
		};

		int[][] test3 = {
			{42}
		};
		int[][] expected3 = {
			{42}
		};

		runTest("Test Case 1 (3x3)", test1, expected1);
		runTest("Test Case 2 (4x4)", test2, expected2);
		runTest("Test Case 3 (1x1)", test3, expected3);
	}
}
