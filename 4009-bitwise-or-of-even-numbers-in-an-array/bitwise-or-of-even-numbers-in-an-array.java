class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int bitwiser=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0)
            bitwiser|=nums[i];
        }
        return bitwiser;
    }
}