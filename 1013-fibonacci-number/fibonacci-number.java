class Solution {
    // public static int[] dp = new int[n+1];
    // static{
    //     Arrays.fill(dp,-1);
    // }
    public int fib(int n) {
        int prev=1;
        int prev2=0;
        int curi=0;
        if(n<=1)return n;
        for(int i=2;i<=n;i++){
            curi=prev+prev2;
            prev2=prev;
            prev=curi;
        }
        return curi;
    }
}