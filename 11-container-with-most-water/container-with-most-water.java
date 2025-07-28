class Solution {
    public int maxArea(int[] height) {
        int i= 0;
        int j= height.length-1;
        int maxhight=0;
        while( i<j){
            int cur= Math.min(height[i] , height[j]) *(j-i);
            maxhight= Math.max(maxhight , cur);
            if(height[i] < height[j]){
                i++;
            } else{
                j--;
            }
        }
        return maxhight;
    }
}