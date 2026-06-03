class Solution {
    public int get(int ind ,int k,int cap ,int[] v ,int[][][] dp){
        if(cap==0)return 0;

        if(ind>=v.length)return 0;
        if(dp[ind][k][cap] !=-1){
            return dp[ind][k][cap];
        }

        if(k == 1){ 
            int buy = -v[ind] + get(ind + 1, 0, cap, v, dp);
            int skip = get(ind + 1, 1, cap, v, dp);
            return dp[ind][k][cap] = Math.max(buy, skip);
            }
        else{ 
            int sell = v[ind] + get(ind + 1, 1, cap - 1, v, dp);
            int skip = get(ind + 1, 0, cap, v, dp);
            return dp[ind][k][cap] = Math.max(sell, skip);
            }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp= new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return get(0, 1, 2, prices, dp);
        
    }
}