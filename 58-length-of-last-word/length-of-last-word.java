class Solution {
    public int lengthOfLastWord(String s) {
        String[] snew = s.split(" ");
        String newerwr  = snew[snew.length -1];
        return newerwr.length();
    }
}