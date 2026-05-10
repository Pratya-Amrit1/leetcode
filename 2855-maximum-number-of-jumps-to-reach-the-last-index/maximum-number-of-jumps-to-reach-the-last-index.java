class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;
        int[] dp =new int[n];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=0;i<n;i++){
            if(i>0 && dp[i]<=0){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                if(Math.abs(nums[i]-nums[j])<=Math.abs(target)){
                    dp[j]=Math.max(dp[j],dp[i]+1);
                }
            }
        }
        return dp[nums.length-1];
    }
}