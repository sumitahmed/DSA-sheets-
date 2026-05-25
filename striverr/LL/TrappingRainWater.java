// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;

//         int PrefixMax[] = new int[n];
//         int SuffixMax[] = new int[n];

//         PrefixMax[0] = height[0];
//         for(int i=1;i<n-1;i++){
//             PrefixMax[i]=Math.max(PrefixMax[i-1],height[i]);
//         }
        
//         SuffixMax[n-1] = height[n-1];
//         for(int i=n-2;i>0;i--){
//             SuffixMax[i]=Math.max(SuffixMax[i+1],height[i]);
//         }

//         int total =0;
//         for(int i=0;i<n;i++){
//             if(height[i]< PrefixMax[i] && height[i]< SuffixMax[i]){
//                 total+=Math.min(PrefixMax[i], SuffixMax[i]) - height[i];
//             }
//         }

//         return total;
//     }
// }

//T.C => O(2n)

class Solution {
    //PrefixMax = LeftMax, SuffixMax = RightMax;
    public int trap(int[] height) {
        int n = height.length;

        int Smax[] = new int[n];
        Smax[n-1] = height[n-1];

        for(int i=n-2;i>=0;i--){
            Smax[i]=Math.max(Smax[i+1], height[i]);
        }

        int Pmax=0, total=0;
        for(int i=0;i<n;i++){
            Pmax=Math.max(Pmax, height[i]);
            if(height[i]<Smax[i] && height[i] <Pmax){
                total+=Math.min(Smax[i],Pmax) -height[i];
            }
        }
        return total;
    }
}