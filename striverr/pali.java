class Solution {
    public boolean isPalindrome(String s) {
        String ss="";
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            ch = Character.toLowerCase(ch);
            if(ch>='a' && ch <='z' || ch>='0' && ch<='9'){
                ss+= ch;
            }
            
        }
        int start = 0;
        int end = ss.length() - 1;
        while(start<end)
        {
            if(ss.charAt(start)!=ss.charAt(end))
            {
                return false;
            }
                start++;
                end --;
        }
        
        return true;
    }
}