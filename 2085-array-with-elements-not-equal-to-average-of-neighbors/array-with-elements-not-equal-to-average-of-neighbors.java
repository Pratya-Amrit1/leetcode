class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);//sorting 
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        //simple two pointer approach
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res[i] = nums[left++];
            } else {
                res[i] = nums[right--];
            }
        }
        return res;
    }
}