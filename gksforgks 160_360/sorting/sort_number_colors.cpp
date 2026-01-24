// Sort 0s, 1s and 2s
// Difficulty: MediumAccuracy: 50.58%Submissions: 836K+Points: 4Average Time: 10m
// Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
// Note: You need to solve this problem without utilizing the built-in sort function.

// Examples:

// Input: arr[] = [0, 1, 2, 0, 1, 2]
// Output: [0, 0, 1, 1, 2, 2]
// Explanation: 0s, 1s and 2s are segregated into ascending order.
// Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
// Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
// Explanation: 0s, 1s and 2s are segregated into ascending order.
// Follow up: Could you come up with a one-pass algorithm using only constant extra space?

// Constraints:
// 1 ≤ arr.size() ≤ 106
// 0 ≤ arr[i] ≤ 2

class Solution {
    public void sort012(int[] arr) {
        /*
        This is a navie approach and will take a lot of time to compile Use Dutch National Flag approach 
        */
        // int temp =0;
        // for(int i=0;i<arr.length;i++){
        //     int flag =0;
        //     for(int j=0;j<arr.length - i - 1;j++){
        //         if(arr[j]>arr[j + 1]){
                    
        //             temp = arr[j];
        //             arr[j]=arr[j+1];
        //             arr[j+1]=temp;
        //             flag=1;
        //         }
        //     }
        // }
        
        int c0=0, c1 =0, c2 =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                c0++;
            }
            else if(arr[i]==1){
                c1++;
            }
            else if(arr[i]==2){
                c2++;
            }
        }
        
        int indx=0;
        for(int i=0;i<c0;i++){
            arr[indx++]=0;
        }
        
        for(int i=0;i<c1;i++){
            arr[indx++]=1;
        }
        
        for(int i=0;i<c2;i++){
            arr[indx++]=2;
        }
    }
}