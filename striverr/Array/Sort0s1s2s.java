import java.util.*;


//Better Approach 

// class Solution {
//     public void sortColors(int[] nums) {
//         int c0=0, c1 =0, c2 =0;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==0){
//                 c0++;
//             }
//             else if(nums[i]==1){
//                 c1++;
//             }
//             else if(nums[i]==2){
//                 c2++;
//             }
//         }
        
//         int indx=0;
//         for(int i=0;i<c0;i++){
//             nums[indx++]=0;
//         }
        
//         for(int i=0;i<c1;i++){
//             nums[indx++]=1;
//         }
        
//         for(int i=0;i<c2;i++){
//             nums[indx++]=2;
//         }
//     }
// }

class Solution {
    // Function to sort array containing 0s, 1s, and 2s using Dutch National Flag Algorithm
    public void sortZeroOneTwo(int[] nums) {
        // Initialize three pointers: low and mid at 0, high at the end
        int low = 0, mid = 0, high = nums.length - 1;

        // Continue processing until mid crosses high
        while (mid <= high) {
            // If current element is 0, swap with low and move both low and mid forward
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            // If current element is 1, just move mid forward
            else if (nums[mid] == 1) {
                mid++;
            }
            // If current element is 2, swap with high and move only high backward
            else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}

// Driver code
class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};

        obj.sortZeroOneTwo(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}