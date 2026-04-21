/*
LeetCode 121 - Best Time to Buy and Sell Stock (Problem Statement)

You are given an integer array prices where prices[i] is the price of a given stock on the i-th day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different
day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,
return 0.

Example 1:
Input: prices = [7, 1, 5, 3, 6, 4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5.

Example 2:
Input: prices = [7, 6, 4, 3, 1]
Output: 0
Explanation: In this case, no transaction is done and the max profit = 0.
*/

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            int cost = prices[i] - min;
            profit = Math.max(cost, profit);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}

public class bestTImetoBuyAndSell {

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static void runTest(String testName, int[] prices, int expected) {
        Solution solution = new Solution();
        int actual = solution.maxProfit(prices);

        System.out.println("---- " + testName + " ----");
        System.out.print("Input prices: ");
        printArray(prices);
        System.out.println("Expected max profit: " + expected);
        System.out.println("Actual max profit:   " + actual);

        if (actual == expected) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }
    }

    public static void main(String[] args) {
        runTest("Test Case 1", new int[] {7, 1, 5, 3, 6, 4}, 5);
        runTest("Test Case 2", new int[] {7, 6, 4, 3, 1}, 0);
        runTest("Test Case 3", new int[] {2, 4, 1}, 2);
        runTest("Test Case 4", new int[] {1}, 0);
    }
}