class Solution {
    public int findKthLargest(int[] nums, int k) {

        int[] top = new int[k];

        // initialize with very small values
        for (int i = 0; i < k; i++) {
            top[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {

            // if current element is bigger than kth largest so far
            if (nums[i] > top[0]) {

                top[0] = nums[i];

                // bubble it to correct position
                for (int j = 0; j < k - 1; j++) {
                    if (top[j] > top[j + 1]) {
                        int temp = top[j];
                        top[j] = top[j + 1];
                        top[j + 1] = temp;
                    } else {
                        break;
                    }
                }
            }
        }

        return top[0]; // kth largest
    }
}
