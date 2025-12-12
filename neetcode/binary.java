class Solution {
    public int search(int[] nums, int target) {
        int beg=0;
        int end= nums.length - 1;
        int mid=0;

        for(int i=0;beg<=end;i++)
        {
            mid = (beg+end)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(target>nums[mid])
            {
                beg = mid+1;
            }
            else{
                end= mid -1;
            }

        }
        return -1;
    }
}