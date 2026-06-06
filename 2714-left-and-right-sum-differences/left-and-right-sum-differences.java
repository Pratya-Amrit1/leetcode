class Solution {
    public int[] leftRightDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int lsum = 0;
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs((sum - lsum - nums[i]) - lsum);
            lsum += nums[i];
        }

        return ans;
    }
}