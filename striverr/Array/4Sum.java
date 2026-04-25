import java.util.*;

class Solution {

    // Function to find all unique quadruplets
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        // Step 1: Sort array
        Arrays.sort(nums);

        // Step 2: First loop for first number
        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Step 3: Second loop for second number
            for (int j = i + 1; j < n; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Step 4: Two pointers
                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        // Skip duplicates for left pointer
                        while (k < l && nums[k] == nums[k - 1]) k++;

                        // Skip duplicates for right pointer
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                    else if (sum < target) {
                        k++;
                    }
                    else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }
}

// Driver class
public class Main {
    public static void main(String[] args) {

        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        Solution obj = new Solution();
        List<List<Integer>> ans = obj.fourSum(nums, target);

        // Print result
        for (List<Integer> quad : ans) {
            System.out.println(quad);
        }
    }
}