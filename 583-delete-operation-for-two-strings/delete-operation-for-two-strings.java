class Solution {
    
  
    int solve(int i, int j, int[][] dp, String text1, String text2) {

        if(i < 0 || j < 0)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] =
                    1 + solve(i - 1, j - 1, dp, text1, text2);
        }

        return dp[i][j] = Math.max(
                solve(i - 1, j, dp, text1, text2),
                solve(i, j - 1, dp, text1, text2)
        );
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, m - 1, dp, text1, text2);
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        return n+m -2* longestCommonSubsequence(word1,word2);
    }
}