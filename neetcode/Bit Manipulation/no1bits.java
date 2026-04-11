// 191. Number of 1 Bits
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).

public class no1bits {
	static class Solution {
		public int hammingWeight(int n) {
			int res = 0;
			while (n != 0) {
				res++;
				n &= (n - 1);
			}
			return res;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int test1 = 11;
		int test2 = 128;
		int test3 = 2147483645;

		System.out.println(solution.hammingWeight(test1));
		System.out.println(solution.hammingWeight(test2));
		System.out.println(solution.hammingWeight(test3));
	}
}