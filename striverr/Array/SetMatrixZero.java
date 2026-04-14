// ============================================================
// LeetCode 73 — Set Matrix Zeroes
// Medium
//
// Problem:
// Given an m x n integer matrix, if an element is 0,
// set its entire row and column to 0's.
// You must do it in place.
//
// Example 1:
//   Input:  [[1,1,1],[1,0,1],[1,1,1]]
//   Output: [[1,0,1],[0,0,0],[1,0,1]]
//
// Example 2:
//   Input:  [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//   Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
// Constraints:
//   m == matrix.length
//   n == matrix[0].length
//   1 <= m, n <= 200
//   -2^31 <= matrix[i][j] <= 2^31 - 1
//
// Approach: Two Arrays (O(m+n) space)
//   1. First pass  — scan matrix, mark Row[i]=1 and Col[j]=1 wherever 0 found
//   2. Second pass — if Row[i]==1 or Col[j]==1, set matrix[i][j]=0
//
// Time:  O(m * n)
// Space: O(m + n)
// ============================================================
class SetZeroes {

    public static void setZeroes(int[][] matrix) {
        int[] Column = new int[matrix[0].length];
        int[] Row    = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    Row[i] = 1;
                    Column[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (Row[i] == 1 || Column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // ---- Helpers ----

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("  [ ");
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println("]");
        }
    }

    static boolean matricesEqual(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                if (a[i][j] != b[i][j]) return false;
        return true;
    }

    static void test(String label, int[][] matrix, int[][] expected) {
        System.out.println("Test: " + label);
        System.out.println("  Input:");
        printMatrix(matrix);

        setZeroes(matrix);

        System.out.println("  After setZeroes:");
        printMatrix(matrix);
        System.out.println("  Expected:");
        printMatrix(expected);

        boolean passed = matricesEqual(matrix, expected);
        System.out.println("  Result: " + (passed ? "PASS ✓" : "FAIL ✗"));
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("===== Set Matrix Zeroes Test Cases =====\n");

        // Test 1 — LeetCode example 1
        test("3x3 matrix, one zero",
            new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
            },
            new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
            }
        );

        // Test 2 — LeetCode example 2
        test("3x3 matrix, two zeros",
            new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
            },
            new int[][]{
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}
            }
        );

        // Test 3 — No zeros at all
        test("No zeros",
            new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            },
            new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            }
        );

        // Test 4 — Entire matrix is zero
        test("All zeros",
            new int[][]{
                {0, 0},
                {0, 0}
            },
            new int[][]{
                {0, 0},
                {0, 0}
            }
        );

        // Test 5 — Zero in corner
        test("Zero in top-left corner",
            new int[][]{
                {0, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            },
            new int[][]{
                {0, 0, 0},
                {0, 5, 6},
                {0, 8, 9}
            }
        );

        // Test 6 — Single row
        test("Single row with zero",
            new int[][]{
                {1, 0, 3}
            },
            new int[][]{
                {0, 0, 0}
            }
        );

        // Test 7 — Single column
        test("Single column with zero",
            new int[][]{
                {1},
                {0},
                {3}
            },
            new int[][]{
                {0},
                {0},
                {0}
            }
        );

        // Test 8 — Multiple zeros in same row
        test("Multiple zeros in same row",
            new int[][]{
                {1, 0, 3, 0},
                {5, 6, 7, 8},
                {9, 1, 2, 3}
            },
            new int[][]{
                {0, 0, 0, 0},
                {5, 0, 7, 0},
                {9, 0, 2, 0}
            }
        );

        System.out.println("========================================");
    }
}