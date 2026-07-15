class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sumofbeauty = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;

                for (int ch = 0; ch < 26; ch++) {
                    int diff = freq[ch];
                    if (diff > 0) {
                        maxi = Math.max(maxi, diff);
                        mini = Math.min(mini, diff);
                    }
                }

                sumofbeauty += (maxi - mini);
            }
        }

        return sumofbeauty;
    }
}