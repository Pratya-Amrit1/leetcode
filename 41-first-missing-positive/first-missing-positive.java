class Solution {
    public int firstMissingPositive(int[] nums) {
        int missing=1;
        Arrays.sort(nums);
        for(int i:nums){
            if(missing==i && i>0){
                missing++;
            }
        }
        return missing;
    }
}