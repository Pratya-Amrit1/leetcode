class Solution {
    public int[] sortEvenOdd(int[] nums) {
        if (nums.length%2 == 0) {
            Solution.quicksort(nums, 1, nums.length+1, false);
            Solution.quicksort(nums, 0, nums.length, true);
        } else {
            Solution.quicksort(nums, 1, nums.length, false);
            Solution.quicksort(nums, 0, nums.length+1, true);
        }
        return nums;
    }
    public static void quicksort(int[] nums, int low, int high, boolean ascending) { //high is not inclusive
        if (low+2 >= high) {return;}
        int pivot = nums[low]; //low to high
        int left = low;
        int right = low+2;
        while (right<high) {
            if ((nums[right] < pivot) == ascending) {
                nums[left] = nums[right];
                left+=2;
                nums[right] = nums[left];
            }
            right+=2;
        }
        nums[left] = pivot;
        Solution.quicksort(nums, low, left, ascending);
        Solution.quicksort(nums, left+2, high, ascending);
    }
}