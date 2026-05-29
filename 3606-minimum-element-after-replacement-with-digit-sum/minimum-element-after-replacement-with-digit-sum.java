class Solution {

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for (int num : nums) {
            ans = Math.min(ans, digitSum(num));
        }

        return ans;
    }
}