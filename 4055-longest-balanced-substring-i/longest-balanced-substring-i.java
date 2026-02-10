class Solution {
    public int longestBalanced(String s) {
        int substringMaxLen = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int maxFreq = 0;
            int uniqueElement = 0;
            
            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                
                if (freq[idx] == 0) {
                    uniqueElement++;
                }
                freq[idx]++;
                maxFreq = Math.max(maxFreq, freq[idx]);
                
                if (maxFreq * uniqueElement == (j - i + 1)) {
                    substringMaxLen = Math.max(substringMaxLen, j - i + 1);
                }
            }
        }
        return substringMaxLen;
    }
}