class Solution {

    void compute(String word, int[][] dp) {
        int n = word.length();
        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(word.charAt(i) == word.charAt(j)) {
                    if(i + 1 < n && j + 1 < n)
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    else
                        dp[i][j] = 1;
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
    }

    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        for(int i = 0; i < n; i++) {
            if(lcp[i][i] != n - i) return "";
        }

        char[] word = new char[n];
        for(int i = 0; i < n; i++) word[i] = '?';

        char c = 'a';

        for(int i = 0; i < n; i++) {
            if(word[i] == '?') {
                if(c > 'z') return "";
                word[i] = c;
                for(int j = i + 1; j < n; j++) {
                    if(lcp[i][j] > 0)
                        word[j] = c;
                }
                c++;
            }
        }

        int[][] dp = new int[n][n];
        compute(new String(word), dp);

        if(java.util.Arrays.deepEquals(dp, lcp))
            return new String(word);

        return "";
    }
}