class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            int product=1;
            int ans=i;
            while(ans>0){
                product*=(ans%10);
                ans=ans/10;
            }
            if(product % t ==0)return i;
            else continue;
        }
        return n;
    }
}