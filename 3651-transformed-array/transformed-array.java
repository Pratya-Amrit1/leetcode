class Solution {
    public int[] constructTransformedArray(int[] nums) {
       
        int[] result = new int[nums.length];
        int n =nums.length;
        for(int i=0;i<nums.length;i++){
            int newIndex = (i + nums[i]) % n;

            if (newIndex < 0) {
                newIndex += n;
            }

            result[i] = nums[newIndex];
        }
        return result;
    }
}