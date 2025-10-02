class Solution {
    public int numWaterBottles(int n, int e) {
        
        return n+(n-1)/(e-1);
    }
}