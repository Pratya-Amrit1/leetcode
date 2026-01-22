class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long  count = 0;
        long  length = 0;
        int start = 0;
        int end = 1;
        while(end  < nums.length) {
            if(nums[end] != nums[end - 1]) {
                end++;
            } else {
                length = end - start;
                count += (length * (length + 1)) / 2;
                start = end;
                end++;
            }
        }
        length = end - start;
        count += (length * (length + 1)) / 2;
        return count;
    }
}