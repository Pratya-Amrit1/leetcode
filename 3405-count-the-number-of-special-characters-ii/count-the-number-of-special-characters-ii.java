class Solution {
    public int numberOfSpecialChars(String word) {
        int res = 0;
    for (char c = 'a'; c <= 'z'; c++) {
        int i = word.lastIndexOf(c);
        int j = word.indexOf(Character.toUpperCase(c));
        if (i != -1 && j != -1 && i < j) res++;
    }    
    return res;
    }
}