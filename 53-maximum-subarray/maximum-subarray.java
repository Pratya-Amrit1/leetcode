class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // Initialize with the first element
        int curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        
        return maxSum;
    }
    
    // public int maxSubArray(int[] nums) {
    //     int maxSum = nums[0];
    //     int currSum = 0;
    //     int n = nums.length;
    //     for (int i = 0; i < n; i++) {
    //         currSum += nums[i];
    //         maxSum = currSum > maxSum ? currSum : maxSum;
    //         if (currSum < 0)
    //             currSum = 0;
    //     }
    //     return maxSum;
        
    // }

}