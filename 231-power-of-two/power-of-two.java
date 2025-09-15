class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        int t= n & (n-1);
        if(t==0){
            return true;
        }
        return false;
    }
}