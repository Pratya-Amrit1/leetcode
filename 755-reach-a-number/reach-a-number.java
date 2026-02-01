class Solution {
    public int reachNumber(int target) {
        target= Math.abs(target);
        int step = 0, dis = 0;
        while (dis < target || (dis - target) % 2 != 0) {
            step++; 
            dis += step;
        }
        return step; 

    }
}