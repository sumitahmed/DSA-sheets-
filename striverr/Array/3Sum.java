import java.util.*;

// Class to solve 3-sum problem
class Solution {

    // Function to find triplets with sum zero
    public List<List<Integer>> threeSum(int[] nums) {

        // Sort the array
        Arrays.sort(nums);

        // Store final result
        List<List<Integer>> ans = new ArrayList<>();

        // First loop for first element
        for (int i = 0; i < nums.length; i++) {

            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Two pointers
            int j = i + 1;
            int k = nums.length - 1;

            // Find pairs for current nums[i]
            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // Skip duplicates for left pointer
                    while (j < k && nums[j] == nums[j - 1]) j++;

                    // Skip duplicates for right pointer
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ans;
    }
}

// Driver class
public class Main {
    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        Solution obj = new Solution();

        List<List<Integer>> res = obj.threeSum(nums);

        // Print result
        for (List<Integer> triplet : res) {
            for (int num : triplet) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}