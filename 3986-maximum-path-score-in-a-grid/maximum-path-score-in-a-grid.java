class Solution {
    public int maxPathScore(int[][] grid, int k) {
        //idea use a dp
        //2d dp
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][k] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = grid[i][j];
                int[] combined = new int[k + 1];
                Arrays.fill(combined, -1);
                //filling the array with -1 as the value
                for (int rk = 0; rk <= k; rk++) {
                    combined[rk] = Math.max(combined[rk], dp[j][rk]);
                }

                if (j > 0) {
                    for (int rk = 0; rk <= k; rk++) {
                        combined[rk] = Math.max(combined[rk], dp[j - 1][rk]);
                    }
                }

                if (curr != 0) {
                    Arrays.fill(dp[j], -1);
                    for (int rk = 1; rk <= k; rk++) {
                        if (combined[rk] != -1) {
                            dp[j][rk - 1] = combined[rk] + curr;
                        }
                    }
                } else {
                    dp[j] = combined;
                }
            }
        }

        int maxVal = -1;
        for (int rk = 0; rk <= k; rk++) {
            maxVal = Math.max(maxVal, dp[n - 1][rk]);
        }
        return maxVal;
    }
}