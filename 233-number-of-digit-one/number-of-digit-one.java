class Solution {

    Integer[][][] dp;

    int f(int idx, int tight, int cnt, String s) {
        if (idx == s.length()) {
            return cnt;
        }
        if (dp[idx][tight][cnt] != null) {
            return dp[idx][tight][cnt];
        }
        int limit = (tight == 1) ? s.charAt(idx) - '0' : 9;
        int ans = 0;
        for (int digit = 0; digit <= limit; digit++) {
            int newTight =
                    (tight == 1 && digit == limit) ? 1 : 0;
            int newCnt = cnt + (digit == 1 ? 1 : 0);
            ans += f(idx + 1, newTight, newCnt, s);
        }
        return dp[idx][tight][cnt] = ans;
    }

    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        dp = new Integer[s.length()][2][s.length() + 1];
        return f(0, 1, 0, s);
    }
}