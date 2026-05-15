class Solution {
    public int findMin(int[] nums) {
        //we will use binay search
        int low=0;
        int high=nums.length-1;
        int ans= Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[low]<=nums[high]){
                ans=Math.min(ans,nums[low]);
            }
            if(nums[low]<=nums[mid]){
                ans=Math.min(nums[low],ans);
                low=mid+1;
            }
            else{
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }
        }
        return ans;

    }
}