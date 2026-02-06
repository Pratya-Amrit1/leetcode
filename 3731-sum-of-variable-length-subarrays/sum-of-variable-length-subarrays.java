class Solution {
    public int subarraySum(int[] nums) {
        int start=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            start=Math.max(0,i-nums[i]);
            while(start<=i){
                sum+=nums[start];
                start++;
            }
        }
        return sum;
    }
}