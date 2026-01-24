import java.util.*;

class A{
    public static void main(String[] args) {
        String s1= "gone";
        String s2= "enog";

        if(s1.length()!=s2.length()){
            System.out.println("false");
        }
        int count[]=new int[256];

        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            count[i]++;
        }

        for (int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            count[i]--;
        }

        for(int i=0;i<256;i++){
            if(count[i]!=0){
                System.out.println("false");
            }
        }

        System.out.println("True");

    }
}