// Reverse array in groups
// Difficulty: Medium
// Accuracy: 37.48%
// Submissions: 371K+
// Points: 4
// Prev
// Average Time: 15m
// Next »
// Given an array arr[l of positive integers. Reverse every sub-array group of size k.
// Note: If at any instance, k is greater or equal to the array size, then reverse the entire
// array.
// Examples:
// Input: arro = [1, 2, 3, 4, 5], k = 3
// Output: [3, 2, 1, 5, 4]
// Explanation: First group consists of elements 1,
// of 4, 5.
// Input: arro = [5, 6, 8, 9], k = 5
// Output: [9, 8, 6, 5]
// 2, 3. Second group consists
// Explnation: Since k is greater than array size, the entire array is reversed.
// Constraints:
// 5
// 1 arr.size(), k S 10
// 5
// 1 arr[i] 10

class Solution {
    public void reverseInGroups(int[] arr, int k) {
        // code here
        int n= arr.length-1;
        //to move in groups as mentioned in the problem use i+=k,
        for(int i=0;i<arr.length;i+=k){
            
            int left = i;
            int right = Math.min(i+k-1,n);
            while(left<right){
            int temp= arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            
            left++;
            right--;
            }
        }
    }
}