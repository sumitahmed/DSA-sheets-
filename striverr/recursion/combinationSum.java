import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    /* ============================================================
     *  SECTION 1: CORE SOLUTION LOGIC (FOR DSA / ONLINE JUDGE)
     * ============================================================ */

    private void findCombinations(int i, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if(i==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[i]<= target){
            ds.add(arr[i]);
            findCombinations(i, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() -1);
        }

        findCombinations(i +1, arr, target, ans, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

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
        List<List<Integer>> actual = solution.combinationSum(candidates, target);

        if (normalize(actual).equals(normalize(expected))) {
            System.out.println("[PASS] " + testName + " -> " + actual);
        } else {
            System.out.println("[FAIL] " + testName);
            System.out.println("  Candidates: " + Arrays.toString(candidates) + ", target=" + target);
            System.out.println("  Expected : " + expected);
            System.out.println("  Actual   : " + actual);
        }
    }

    // Keep all test cases in a different function so they stay separated from core logic.
    private static void runAllTestCases() {
        Solution solution = new Solution();

        System.out.println("============================================================");
        System.out.println("               RUNNING COMBINATION SUM TESTS               ");
        System.out.println("============================================================");

        runTest(
                "Example 1",
                solution,
                new int[]{2, 3, 6, 7},
                7,
                Arrays.asList(
                        Arrays.asList(2, 2, 3),
                        Arrays.asList(7)
                )
        );

        runTest(
                "Example 2",
                solution,
                new int[]{2, 3, 5},
                8,
                Arrays.asList(
                        Arrays.asList(2, 2, 2, 2),
                        Arrays.asList(2, 3, 3),
                        Arrays.asList(3, 5)
                )
        );

        runTest(
                "No solution",
                solution,
                new int[]{2},
                1,
                new ArrayList<>()
        );

        runTest(
                "Single candidate reused",
                solution,
                new int[]{1},
                2,
                Arrays.asList(
                        Arrays.asList(1, 1)
                )
        );

        runTest(
                "Multiple paths",
                solution,
                new int[]{8, 7, 4, 3},
                11,
                Arrays.asList(
                        Arrays.asList(8, 3),
                        Arrays.asList(7, 4),
                        Arrays.asList(4, 4, 3)
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