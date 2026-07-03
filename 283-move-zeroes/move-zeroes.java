class Solution {
    public void moveZeroes(int[] nums) {
        int nozero=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[nozero]=nums[i];
                nozero++;
            }
        }
        while(nozero<n){
            nums[nozero]=0;
            nozero++;
        }
    }
}