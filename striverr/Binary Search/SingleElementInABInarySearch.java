class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        //trmming down the boundaries by 1
        int low = 1, high = n-2;

        //edge cases
        
        //1. single element 
        if(n==1) return nums[0];
        //2. first element && last element
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }

        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid]!= nums[mid-1] && nums[mid]!= nums[mid+1]){
                return nums[mid];
            }

            //Elimination 

            //LeftyHalf

            if( 
            //Standing on Left Half even idex
            (mid%2==0) && nums[mid]==nums[mid+1] || 
            //Standing on Left Half Oddd idex
            (mid%2==1) && nums[mid]==nums[mid-1] 
            ){
                low= mid+1; //eliminates left half
            }

            else{
                high = mid-1; //eliminates rigth half;
            }
        }
        return -1;
    }
}