class Solution {
    int MOD = 1000000007;
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][][] dp = new long[n][m][2];
        dp[0][0][0] = grid[0][0] * 1L;
        dp[0][0][1] = grid[0][0] * 1L;

        for(int i = 1; i < m; i++) {
            long value = grid[0][i] * 1L;
            dp[0][i][0] = Math.max(value * dp[0][i - 1][0], value * dp[0][i - 1][1]);
            dp[0][i][1] = Math.min(value * dp[0][i - 1][0], value * dp[0][i - 1][1]);
        }

        for(int i = 1; i < n; i++) {
            long value = grid[i][0] * 1L;
            dp[i][0][0] = Math.max(value * dp[i - 1][0][0], value * dp[i - 1][0][1]);
            dp[i][0][1] = Math.min(value * dp[i - 1][0][0], value * dp[i - 1][0][1]);
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {

                long value = grid[i][j] * 1L;

                long a = Math.max(value * dp[i - 1][j][0], value * dp[i - 1][j][1]);
                long b = Math.min(value * dp[i - 1][j][0], value * dp[i - 1][j][1]);

                long c = Math.max(value * dp[i][j - 1][0], value * dp[i][j - 1][1]);
                long d = Math.min(value * dp[i][j - 1][0], value * dp[i][j - 1][1]);

                dp[i][j][0] = Math.max(a, c);
                dp[i][j][1] = Math.min(b, d);
            }
        }
        return (dp[n - 1][m - 1][0] < 0) ? -1 : (int)(dp[n - 1][m - 1][0]% MOD);
    }
}