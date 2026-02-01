class Solution {
    public int minimumCost(int[] nums) {
        int first =51;
        int second=51 ;
        for(int i=1;i<nums.length ;i++){
            if(first>nums[i]){
                second = first;
                first=nums[i];
            }
            else if(second>=nums[i] ){
                second=nums[i];
            }
        }
        
        return nums[0]+first+second;
        // Arrays.sort(nums,1,nums.length);

        // return nums[0]+nums[1]+nums[2];
    }
}