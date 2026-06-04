class Solution {

    int f(int ind, int k, int[] coins, int[][] dp) {
        if (k == 0) return 0;
        if (ind < 0) return (int)1e9;
        if (dp[ind][k] != -1) return dp[ind][k];
        int notTake = f(ind - 1, k, coins, dp);
        int take = (int)1e9;
        if (k >= coins[ind]) {
            take = 1 + f(ind, k - coins[ind], coins, dp);
        }

        return dp[ind][k] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = f(n - 1, amount, coins, dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
}