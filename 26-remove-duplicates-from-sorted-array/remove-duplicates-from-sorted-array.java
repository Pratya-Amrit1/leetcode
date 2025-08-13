class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        int n = nums.length;

        while (j < n) {
            if (nums[j] == nums[i]) {
                j++; // Skip duplicates
            } else {
                i++;
                nums[i] = nums[j]; // Place next unique element
            }
        }

        return i + 1; // New length
    }
}