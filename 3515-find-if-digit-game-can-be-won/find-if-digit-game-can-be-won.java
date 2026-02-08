class Solution {
    public boolean canAliceWin(int[] nums) {
        int sumsin=0;
        int sumdoub=0;
       for(int i=0;i<nums.length;i++){
        if(nums[i]<10){
            sumsin+=nums[i];
        }else{
            sumdoub+=nums[i];
        }
       }
       return sumsin!=sumdoub;
    }
}