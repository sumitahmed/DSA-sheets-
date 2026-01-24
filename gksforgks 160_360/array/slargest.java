class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest=-1;
        int slargest=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>largest)
            {
                
                slargest=largest;
                largest=arr[i];
            }
            else if(arr[i]<largest && arr[i]>slargest)
            {
                slargest=arr[i];
            }
        }
        return slargest;
    }
}