class Solution {

   

    public int majorityElement(int[] nums) {

         //brute force:

        // int n=nums.length;

        // for(int i=0;i<n;i++){
        //     int c=0;
        //     for(int j=0;j<n;j++){
        //         if(nums[i]==nums[j]){
        //             c++;
        //         }
        //     }
        // if(c> (n/2)){
        //     return nums[i];
        // }
        // }
        // return -1;

        //Optimal: Moore's Voting

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
public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        
        // Create an instance of Solution class
        Solution sol = new Solution();

        // Call the majorityElement function
        int ans = sol.majorityElement(arr);
        
        // Print the majority element
        System.out.println("The majority element is: " + ans);
    }
}