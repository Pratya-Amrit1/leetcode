class Solution {
    public int smallestNumber(int n) {
        // if(n==1)return 1;
        // if(n==4)return 7;
        int i=1;
        while(Math.pow(2,i)<n){
            i++;
        }
        if(Math.pow(2,i)-1 <n){
            return (int)Math.pow(2,++i)-1;
        }
        return (int)Math.pow(2,i)-1;
    }
}