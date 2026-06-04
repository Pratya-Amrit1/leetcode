class Solution {
    public int lastStoneWeightII(int[] nums) {
        int tolsum=0;
        int n= nums.length;
        for(int i=0;i<n;i++){
            tolsum+=nums[i];
        }
        int k=tolsum;
        boolean[][] dp = new boolean[n][k+1];
        for(int i=0;i<n;i++) dp[i][0]=true;
        if(nums[0]<=k ) dp[0][nums[0]]=true;
        for(int i=1;i<n;i++){
            for(int target=1;target<=k;target++){
                boolean notake= dp[i-1][target];
                boolean take =false;
                if(nums[i]<=target)take = dp[i-1][target-nums[i]];
                dp[i][target] = take || notake;
            }
        } 
        int mini= (int) 1e9;
        for(int s1 =0;s1<=tolsum/2;s1++){
            if(dp[n-1][s1]== true){
                mini =Math.min(mini , Math.abs((tolsum-s1)-s1));
            }
        }
        return mini;
    }
}