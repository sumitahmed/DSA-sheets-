import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    /* ============================================================
     *  SECTION 1: CORE SOLUTION LOGIC (FOR DSA / ONLINE JUDGE)
     * ============================================================ */

    private void findCombinations(int i, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int j = i; j < arr.length; j++) {
            if (j > i && arr[j] == arr[j - 1]) {
                continue;
            }
            if (arr[j] > target) {
                break;
            }
                ds.add(arr[j]);
                findCombinations(j + 1, arr, target - arr[j], ans, ds);
                ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

            /* ============================================================
             *  SECTION 2: TESTING UTILITIES (LOCAL VERIFICATION ONLY)
             * ============================================================ */

            private static List<String> normalize(List<List<Integer>> combinations) {
            List<String> normalized = new ArrayList<>();
            for (List<Integer> combination : combinations) {
                List<Integer> sortedCombination = new ArrayList<>(combination);
                Collections.sort(sortedCombination);
                normalized.add(sortedCombination.toString());
            }
            Collections.sort(normalized);
            return normalized;
            }

            private static void runTest(
                String testName,
                Solution solution,
                int[] candidates,
                int target,
                List<List<Integer>> expected
            ) {
            List<List<Integer>> actual = solution.combinationSum2(candidates, target);

            if (normalize(actual).equals(normalize(expected))) {
                System.out.println("[PASS] " + testName + " -> " + actual);
            } else {
                System.out.println("[FAIL] " + testName);
                System.out.println("  Candidates: " + Arrays.toString(candidates) + ", target=" + target);
                System.out.println("  Expected : " + expected);
                System.out.println("  Actual   : " + actual);
            }
            }

            // Keep all test cases in a dedicated function for clear separation.
            private static void runAllTestCases() {
            Solution solution = new Solution();

            System.out.println("============================================================");
            System.out.println("              RUNNING COMBINATION SUM II TESTS             ");
            System.out.println("============================================================");

            runTest(
                "Example 1",
                solution,
                new int[]{10, 1, 2, 7, 6, 1, 5},
                8,
                Arrays.asList(
                    Arrays.asList(1, 1, 6),
                    Arrays.asList(1, 2, 5),
                    Arrays.asList(1, 7),
                    Arrays.asList(2, 6)
                )
            );

            runTest(
                "Example 2",
                solution,
                new int[]{2, 5, 2, 1, 2},
                5,
                Arrays.asList(
                    Arrays.asList(1, 2, 2),
                    Arrays.asList(5)
                )
            );

            runTest(
                "No solution",
                solution,
                new int[]{3, 4, 7},
                2,
                new ArrayList<>()
            );

            runTest(
                "Uses each element once",
                solution,
                new int[]{1, 1, 1, 2, 2},
                3,
                Arrays.asList(
                    Arrays.asList(1, 1, 1),
                    Arrays.asList(1, 2)
                )
            );

            runTest(
                "Single valid pair",
                solution,
                new int[]{1, 1},
                2,
                Arrays.asList(
                    Arrays.asList(1, 1)
                )
            );
            }

            public static void main(String[] args) {
            /* ============================================================
             *  SECTION 3: ENTRY POINT FOR RUNNING TEST CASES
             * ============================================================ */
            runAllTestCases();
            }
}