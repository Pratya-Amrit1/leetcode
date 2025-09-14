class Solution {
    public int helpering(int[] nums , int k){
        if(k<0) return 0;
        int l=0 ,r=0 , sum =0 , cnt=0;
        while(r<nums.length){
            sum+= (nums[r] %2);
            while(sum>k){
                sum -=(nums[l]%2);
                l=l+1;
            }
            cnt += (r-l+1);
            r++;
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return  helpering(nums , k) - helpering(nums ,k-1);
    }
}