class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                count++;
                res = Math.max(res,count);
            }
            else{
                count = 1;
            }
        }
        return res;
    }
}