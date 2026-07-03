class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi=0;
        int totmax=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                maxi++;
                totmax=Math.max(maxi,totmax);
            }
            else{
                maxi=0;
            }
        }
        return totmax;
    }
}