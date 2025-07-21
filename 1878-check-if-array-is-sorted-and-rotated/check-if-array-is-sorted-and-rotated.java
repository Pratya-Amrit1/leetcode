class Solution {
    public boolean check(int[] nums) {
        int count =0;
        int n= nums.length;
        for(int i=0 ; i<n;i++){
            if(nums[i]> nums[(i+1)%n]){ //modulo is used to find the  small no and the s

            ++count;
            }
        }
        return (count<=1);
    }
}