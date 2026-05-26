class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] uppper = new boolean[26];
        for(char ch : word.toCharArray()){
            if(Character.isLowerCase(ch)){
                lower[ch - 'a'] = true;
            }
            else{
                uppper[ch - 'A'] = true;
            }
        }
        int cnt = 0;
        for(int i = 0; i < 26; i++){
            if(lower[i] && uppper[i]) cnt++;
        }
        return cnt;
    }
}