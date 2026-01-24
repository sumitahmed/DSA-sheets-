class Solution {
    public int cntSpecialNum(int arr[]) {
        // code here\
        // int count=0;
        
        // int n= arr.length;
        // for(int i=0;i<n;i++){
        //     boolean isSpecial = false;
            
        //     for(int j=0;j<n;j++){
        //         if(i!=j && arr[i]%arr[j]==0){
        //             isSpecial = true;
        //             break;
        //         }
        //     }
        //     if(isSpecial){
        //         count++;
        //     }
        // }
        
        
        // return count;
        
        
        int MAX = 1000000;
        int freq[] = new int[MAX +1];
        
        //freq of each number
        for(int num: arr){
            freq[num]++;
        }
        
        int c=0;
        
        for(int num: arr){
            
            //case of duplicate number
            if(freq[num]>1){
                c++;
                continue;
            }
            
            boolean special = false;
            
            for(int d = 1;d*d<=num;d++){
                if(num%d==0){
                    int o1 = d;
                    int o2= num/d;
                    
                    if(o1 != num && freq[o1]>0){
                        special = true;
                        break;
                    }
                    
                    //
                    
                    if(o2!=num && freq[o2]>0){
                        special = true;
                        break;
                    }
                }
            }
            
            
            if(special){
                c++;
            }
        }
        return c;
    }
}