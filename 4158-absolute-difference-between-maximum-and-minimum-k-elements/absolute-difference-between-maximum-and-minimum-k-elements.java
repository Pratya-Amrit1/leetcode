class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        int s1=0;
        int s2=0;
        while(i<k&&i<n)
        {
            s1+=nums[i];
            s2+=nums[n-i-1];
            i++;
        } 
        return Math.abs(s1-s2);
    }
}