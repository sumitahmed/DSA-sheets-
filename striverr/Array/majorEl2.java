class Solution {
    public int majorityElement(int[] nums) {
        int c=0;
        int el=0;

        for(int i=0;i<nums.length;i++){
            if(c==0){ //we assign 
                c=1;
                el=nums[i];
            }
            else if(nums[i]==el){ //equivalent ie aoppeared again 
                c++;
            }else{
                c--;
            }
        }

        //now that you got the element now just iterate 
        //now chekc ifg majority 
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==el){
                count++;
            }
        }
        if(count> (nums.length) /2 ){
            return el;
        }
        return -1;
    }
    
}