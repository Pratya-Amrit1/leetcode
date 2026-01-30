class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxdiff = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            maxdiff=Math.max(maxdiff,Math.abs(nums[i-1] - nums[i]));
        }
        maxdiff=Math.max(maxdiff ,Math.abs(nums[0] - nums[nums.length -1]));
        return maxdiff;
    }
}