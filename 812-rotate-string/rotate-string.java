class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        String newt=s+s;

        return newt.contains(goal);
    }
}