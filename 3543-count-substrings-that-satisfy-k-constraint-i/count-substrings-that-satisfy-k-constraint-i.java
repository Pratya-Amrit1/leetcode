class Solution {
    public int countKConstraintSubstrings(String s, int t) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int zeroCount = 0, oneCount = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
                
                if (zeroCount <= t || oneCount <= t) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
