// Count Inversions
// Difficulty: MediumAccuracy: 16.93%Submissions: 733K+Points: 4
// Given an array of integers arr[]. You have to find the Inversion Count of the array. 
// Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

// Examples:

// Input: arr[] = [2, 4, 1, 3, 5]
// Output: 3
// Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
// Input: arr[] = [2, 3, 4, 5, 6]
// Output: 0
// Explanation: As the sequence is already sorted so there is no inversion count.
// Input: arr[] = [10, 10, 10]
// Output: 0
// Explanation: As all the elements of array are same, so there is no inversion count.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 104

class Solution {
    static int count;
    static int inversionCount(int arr[]) {
        // Code Here
        count =0;
        mergeSort(arr, 0, arr.length-1);
        
        return (int) count;
        
    }
    {
        
    }
    static void mergeSort(int[] arr, int beg, int end)
    {
        if(beg<end){
            int mid =(beg+end)/2;
            
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, beg, mid, end);
        }
    }
    
    static void merge(int[] arr, int beg, int mid, int end){
        int i= beg, j= mid+1, k=0;
        
        int[] temp = new int[end - beg+1];
        
        while(i<=mid && j<=end){
            if(arr[i] <= arr[j]){
                temp[k++]= arr[i++];
                
            }
            else{
                count +=(mid -i +1);
                temp[k++]= arr[j++];
            }
        }
        
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        
        while(j<=end){
            temp[k++]=arr[j++];
        }
        
        for(int a=0;a<temp.length;a++){
            arr[beg+a]=temp[a];
        }
    }
}