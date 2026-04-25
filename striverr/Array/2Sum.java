class Solution {
    public int[] twoSum(int[] nums, int target) {
        //BRute Force:

        //   for(int i=0;i<nums.length;i++){
        //     for(int j=0;j<nums.length;j++){
        //         if(i==j) continue;
        //         else if(nums[i]+nums[j] == target){
        //             return new int[]{i, j}; 
        //         }
        //     }
        //   }
        //   return new int[]{-1, -1};

        //Optimal:

        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0;i<n;i++){
            int val = target - nums[i];

            if(mp.containsKey(val)){
                return new int[]{mp.get(val),i};
            }
            mp.put(nums[i], i);
        }
        return null;
    }
} 