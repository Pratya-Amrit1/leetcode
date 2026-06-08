class Solution {
     public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if ((totalSum - target) < 0 || (totalSum - target) % 2 != 0)
            return 0; 
        int subsetSum = (totalSum - target) / 2;
        int[][] dp = new int[nums.length][subsetSum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return count(nums, nums.length - 1, subsetSum, dp);
    }
    private int count(int[] nums, int ind, int target, int[][] dp) {

        if (ind == 0) {
            if (target == 0 && nums[0] == 0) return 2;

            if (target == 0 || target == nums[0]) return 1;
            return 0;
        }
        if (dp[ind][target] != -1) return dp[ind][target];
        int notPick = count(nums, ind - 1, target, dp);
        int pick = 0;
        if (nums[ind] <= target)
            pick = count(nums, ind - 1, target - nums[ind], dp);

        return dp[ind][target] = pick + notPick;
    }
}