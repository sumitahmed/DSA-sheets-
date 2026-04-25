import java.util.*;

class Solution {

    public int longestConsecutive(int[] nums) {

        // Get the length of the array
        int n = nums.length;

        // If the array is empty, no sequence exists
        if (n == 0) return 0;

        // Variable to store the longest sequence length found
        int longest = 1;

        // HashSet to store unique elements for O(1) lookup
        Set<Integer> st = new HashSet<>();

        // Add all elements to the set to remove duplicates
        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        /* Loop through each element in the set to find 
           the starting point of consecutive sequences */
        for (int it : st) {

            // If there is no number before 'it', it’s the start of a sequence
            if (!st.contains(it - 1)) {

                // Start the count for this sequence
                int c = 1;

                // Store the current number
                int x = it;

                // Keep checking for the next consecutive number
                while (st.contains(x + 1)) {
                    x = x + 1;   // move forward
                    c = c + 1;   // increase length
                }

                // Update the longest sequence length if needed
                longest = Math.max(longest, c);
            }
        }

        // Return the length of the longest sequence
        return longest;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {100, 4, 200, 1, 3, 2};

        // Create object
        Solution obj = new Solution();

        // Call function
        int ans = obj.longestConsecutive(nums);

        // Print result
        System.out.println("Longest Consecutive Sequence Length: " + ans);
    }
}