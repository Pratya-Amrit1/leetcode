class Solution {
    public boolean isPalindrome(int x) {
        int original =x;
        int rev =0;
        while(original >0){
            rev = rev * 10+original %10;
            original /=10;
        }
        return x == rev;
    }
}