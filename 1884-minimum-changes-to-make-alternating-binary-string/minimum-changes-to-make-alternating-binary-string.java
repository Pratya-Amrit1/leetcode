class Solution {
    public int minOperations(String s) {
        int len = s.length();
        char flipBit = '0';
        int count = 0;
        int count2 = 0;
        char flipBitrev = '1';
        
        char[] s1 = s.toCharArray();

        for(int i = 0; i < len; i++) {
            if(s1[i] != flipBit) {
                count++;
            }
            flipBit = (flipBit == '0') ? '1' : '0';
        }

        for(int i = 0; i < len; i++) {
            if(s1[i] != flipBitrev) {
                count2++;
            }
            flipBitrev = (flipBitrev == '0') ? '1' : '0';
        }
        
        return Math.min(count, count2);
    }
}