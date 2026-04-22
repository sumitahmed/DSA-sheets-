import java.util.*;

class Solution {
    // Function to merge overlapping intervals
    public List<List<Integer>> merge(int[][] intervals) {
        // Sort intervals based on start time
        Arrays.sort(
            intervals,
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // List to store merged intervals
        List<List<Integer>> merged = new ArrayList<>();

        // Traverse through all intervals
        for (int[] interval : intervals) {
            // If merged list is empty or no overlap
            if (
                merged.isEmpty() ||
                merged.get(merged.size() - 1).get(1) < interval[0]
            ) {
                // Add current interval as a new block
                merged.add(
                    Arrays.asList(interval[0], interval[1])
                );
            } else {
                // Overlapping: update end to max of both
                int last = merged.size() - 1;
                int maxEnd = Math.max(
                    merged.get(last).get(1),
                    interval[1]
                );
                merged.get(last).set(1, maxEnd);
            }
        }

        return merged;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {
            {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        List<List<Integer>> result = sol.merge(intervals);

        for (List<Integer> interval : result) {
            System.out.print(
                "[" + interval.get(0) + "," + interval.get(1) + "] "
            );
        }
    }
}
