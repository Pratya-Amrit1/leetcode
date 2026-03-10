class Solution {
    int f(int idx , int[] nums ,int[] dp){
        if(idx==0){
            return nums[idx];
        }
        if(idx<0)return 0;
        if(dp[idx] !=-1)return dp[idx];
        int pick = nums[idx]+ f(idx-2,nums,dp);
        int nopick= 0+f(idx-1,nums,dp);
        return dp[idx]=Math.max(pick,nopick);
    }
    public int rob(int[] nums) {
        // int n= nums.length;
        // int[] dp = new int[n];
        // dp[0]=nums[0];
        // int neg=0;
        // int take=0,notake=0;
        // for(int i=1;i<n;i++){
        //     take = nums[i];
        //     if(i>1) take+=dp[i-2];
        //     notake =0+dp[i-1];
        //     dp[i]= Math.max(take,notake);
        //             }
        //             return dp[n-1];
        // Arrays.fill(dp,-1);
        // return f(n-1,nums,dp);

        int n = nums.length;
        int prev=nums[0];
        int prev2=0;

        for(int i=1;i<n;i++){
            int take = nums[i];
            if(i>1)take+=prev2;
            int notake = 0+prev;
            int curr =Math.max(take,notake);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}