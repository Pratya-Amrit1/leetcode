class Solution {
    public boolean check(int[] nums) {
        int breaki=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                breaki++;
            }
        }
            if(nums[0]<nums[nums.length-1]){
                breaki++;
            }
        if( breaki>1){
            return false;
        }
        return true;
    }
}