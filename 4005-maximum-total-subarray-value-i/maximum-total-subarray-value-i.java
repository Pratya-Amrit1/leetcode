class Solution {
    public long maxTotalValue(int[] nums, int k) {
        //select subarray k times and 
        int n=nums.length;
        long maxi=Integer.MIN_VALUE;
        long mini=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            maxi=Math.max(nums[i],maxi);
            mini=Math.min(nums[i],mini);
        }
        return (maxi-mini)*k;
    }
}