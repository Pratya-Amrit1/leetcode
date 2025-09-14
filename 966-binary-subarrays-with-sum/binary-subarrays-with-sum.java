class Solution {
    public int fcukit(int[] nums, int goal) {
        if(goal<0)return 0;
        int res =0 , l=0 ,r=0 ,cnt=0 ,sume=0;
        while(r<nums.length){
            sume+=nums[r];
            while(sume>goal){
                sume= sume - nums[l];
                l++;
            }
            cnt = cnt+ (r-l+1);
            r++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums , int goal){
        return fcukit(nums,goal) - fcukit(nums , goal -1);
    }
}