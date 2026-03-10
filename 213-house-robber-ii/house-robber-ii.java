class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int prev=nums[0];
        int prev2=0;
        int n= nums.length;
        for(int i=1;i<n-1;i++){
            int take = nums[i];
            if(i>1){
                take+=prev2;
            }
            int notake =0+prev;
            int curr=Math.max(take,notake);
            prev2=prev;
            prev=curr;
        }
        int ans=prev;
        prev=nums[1];
        prev2=0;
        for(int i=2;i<n;i++){
            int take = nums[i];
            if(i>1){
                take+=prev2;
            }
            int notake =0+prev;
            int curr=Math.max(take,notake);
            prev2=prev;
            prev=curr;
        }
        int ans2= prev;
        return Math.max(ans,ans2);
    }
}