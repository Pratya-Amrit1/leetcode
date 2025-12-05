class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int l=0;
        int r= nums.length -1;
        while(l<=r){
            int mid= l+(r-l)/2;

            if(nums[l]<=nums[r]){
                ans = Math.min(ans ,nums[l]);
            }
             if(nums[l]<=nums[mid]){
                ans= Math.min(ans,nums[l] );
                l=mid+1;
            }
            else{
                ans= Math.min(ans,nums[mid]);
                r=mid-1;
            }
        }
        return ans;
    }
}