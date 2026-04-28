import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        // ========================
        // Brute Force Approach
        // Time Complexity: O(n^2) - two nested loops, each up to n iterations
        // Space Complexity: O(256) = O(1) - fixed-size visited array
        // ========================

        // int maxLen = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     boolean visited[] = new boolean[256];
        //     int currLen = 0;

        //     for (int j = i; j < s.length(); j++) {
        //         char ch = s.charAt(j);

        //         /* If character already visited,
        //            break out of inner loop */
        //         if (visited[ch]) {
        //             break;
        //         }

        //         visited[ch] = true;
        //         currLen++;
        //     }

        //     if (currLen > maxLen) {
        //         maxLen = currLen;
        //     }
        // }
        // return maxLen;

        // ========================
        // Optimized Sliding Window Approach
        // Time Complexity: O(n) - single pass with two pointers over the string
        // Space Complexity: O(256) = O(1) - fixed-size hash array for ASCII chars
        // ========================

        int n = s.length();

        // Assuming all ASCII characters
        int HashLen = 256;

        /* Hash table to store last
           occurrence of each character */
        int[] hash = new int[HashLen];

        /* Initialize hash table with
           -1 (indicating no occurrence) */
        Arrays.fill(hash, -1);

        int l = 0, r = 0, maxLen = 0;
        while (r < n) {
            /* If current character s.charAt(r)
               is already in the substring */
            if (hash[s.charAt(r)] >= l) {
                /* Move left pointer to the right
                   of the last occurrence of s.charAt(r) */
                l = Math.max(hash[s.charAt(r)] + 1, l);
            }

            // Calculate the current substring length
            int len = r - l + 1;

            // Update maximum length found so far
            maxLen = Math.max(len, maxLen);

            /* Store the index of the current
               character in the hash table */
            hash[s.charAt(r)] = r;

            // Move right pointer to next position
            r++;
        }

        // Return the maximum length found
        return maxLen;
    }
}

public class Main {
    public static void main(String[] args) {
        String s = "cadbzabcd";

        // Create an instance of the Solution class
        Solution sol = new Solution();

        int result = sol.lengthOfLongestSubstring(s);

        // Output the maximum length
        System.out.println("The maximum length is:");
        System.out.println(result);
    }
}