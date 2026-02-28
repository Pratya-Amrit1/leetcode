class Solution {
    int m =(int)1e9+7;
    public int concatenatedBinary(int n) {
        int digit=0;
        long result=0;
        for(int i=1;i<=n;i++){
            if((i & (i-1)) ==0){
                digit++;
            }
            result=((result<<digit)%m+i)%m;
        }
        return (int)result;
    }
}