class Solution {
    public void reverseString(char[] s) {
        int n= s.length-1;
        int i=0;
        while(i<n){
            char temp=s[i];
            s[i]=s[n];
            s[n]=temp;
            i++;
            n--;
        }
        
    }
}