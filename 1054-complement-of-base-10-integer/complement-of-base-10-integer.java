class Solution {
    public int bitwiseComplement(int n) {
        if (n==0)
       return 1;
        int ans=0;
        int pow=1;
        while(n!=0){
            if(n%2==0){
                ans+=(pow*1);
            }else{
                ans+=(pow*0);
            }
            pow*=2;
            n/=2;
        }
        return ans;
    }
}