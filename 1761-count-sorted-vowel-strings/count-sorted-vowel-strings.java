class Solution {
      public int countVowelStrings(int n) {

        if(n==1) return 5;

        String[] vowels = {"a","e","i","o","u"};
        int[][] dp = new int[5][n+1];

        for(int i=0;i<5;i++) {
            dp[i][n] = 1;
        }

        for(int len=n-1;len>=0;len--) {
            for(int idx=4;idx>=0;idx--) {
                if(idx==4) {
                    dp[idx][len] = dp[idx][len+1];
                }else {
                    dp[idx][len] = dp[idx+1][len] + dp[idx][len+1];
                }
            }
        }

        return dp[0][0];
    }
}