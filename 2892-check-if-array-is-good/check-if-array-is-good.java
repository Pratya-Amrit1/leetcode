class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        if(n==1){
            return false;
        }
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(nums[i]!=i+1){
                return false;
            }
            else {
                continue;
            }
        }
        //if l=4
        //no repeat till 2 n-2
        //n-2 and n-1 should be equal to n-1
        if(nums[n-1]==nums[n-2] && nums[n-1]==n-1){
            return true;
        }
        return false;
    }
}