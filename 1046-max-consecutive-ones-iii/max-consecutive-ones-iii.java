class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int maxle =0; 
        int r=0; 
        int zero =0;

        while(r< nums.length){
            if(nums[r]== 0){
                zero++;
            }
            if(zero >k){
                if(nums[l]==0) zero--;
                l++;
            }
            if(zero <=k){
                int len = r - l+1;
                maxle= Math.max(len ,maxle);
            }
            r++;
        }
        return maxle;
    }
}