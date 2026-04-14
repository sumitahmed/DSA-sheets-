// ============================================================
// LeetCode 118 — Pascal's Triangle
// Easy
//
// Problem:
// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers above it.
//
// Example:
//   Input:  numRows = 5
//   Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
// Approach: nCr Formula per row
//   - Each row element = prev element * (row - col) / col
//   - Avoids recomputing from scratch for each element
//
// Time:  O(n^2)
// Space: O(n^2)
// ============================================================

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    // Generates a single row of Pascal's Triangle using nCr formula
    // Each element = previous element * (row - col) / col
    private static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();

        // Every row starts with 1
        ansRow.add(1);

        // Calculate remaining elements using nCr: C(row-1, col)
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);   // numerator step
            ans /= col;                // denominator step — gives next element
            ansRow.add((int) ans);
        }

        return ansRow;  // e.g row=5 → [1, 4, 6, 4, 1]
    }

    // Calls generateRow() for each row from 1 to numRows
    // Collects all rows into final 2D list and returns it
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        // i=1 gives [1], i=2 gives [1,1], i=3 gives [1,2,1] and so on
        for (int i = 1; i <= numRows; i++) {
            ans.add(generateRow(i));   // build row i and add to result
        }

        return ans;
    }

    // ---- Helpers ----

    static void test(String label, int numRows, List<List<Integer>> expected) {
        List<List<Integer>> result = generate(numRows);
        boolean passed = result.equals(expected);

        System.out.println("Test: " + label);
        System.out.println("  Input:    numRows = " + numRows);
        System.out.println("  Output:   " + result);
        System.out.println("  Expected: " + expected);
        System.out.println("  Result:   " + (passed ? "PASS ✓" : "FAIL ✗"));
        System.out.println();
    }

    // Quick helper to build expected list cleanly
    static List<List<Integer>> buildExpected(int[]... rows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : rows) {
            List<Integer> r = new ArrayList<>();
            for (int val : row) r.add(val);
            result.add(r);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println("===== Pascal's Triangle Test Cases =====\n");

        // Test 1 — LeetCode example 1
        test("numRows = 5",
            5,
            buildExpected(
                new int[]{1},
                new int[]{1, 1},
                new int[]{1, 2, 1},
                new int[]{1, 3, 3, 1},
                new int[]{1, 4, 6, 4, 1}
            )
        );

        // Test 2 — LeetCode example 2
        test("numRows = 1",
            1,
            buildExpected(
                new int[]{1}
            )
        );

        // Test 3 — Two rows
        test("numRows = 2",
            2,
            buildExpected(
                new int[]{1},
                new int[]{1, 1}
            )
        );

        // Test 4 — Six rows
        test("numRows = 6",
            6,
            buildExpected(
                new int[]{1},
                new int[]{1, 1},
                new int[]{1, 2, 1},
                new int[]{1, 3, 3, 1},
                new int[]{1, 4, 6, 4, 1},
                new int[]{1, 5, 10, 10, 5, 1}
            )
        );

        // Test 5 — Ten rows (big case)
        test("numRows = 10",
            10,
            buildExpected(
                new int[]{1},
                new int[]{1, 1},
                new int[]{1, 2, 1},
                new int[]{1, 3, 3, 1},
                new int[]{1, 4, 6, 4, 1},
                new int[]{1, 5, 10, 10, 5, 1},
                new int[]{1, 6, 15, 20, 15, 6, 1},
                new int[]{1, 7, 21, 35, 35, 21, 7, 1},
                new int[]{1, 8, 28, 56, 70, 56, 28, 8, 1},
                new int[]{1, 9, 36, 84, 126, 126, 84, 36, 9, 1}
            )
        );

        System.out.println("========================================");
    }
}