class Solution {
    public int findGCD(int[] nums) {
        int mini =nums[0];
        int maxi=nums[0];
        for(int i = 0 ;i<nums.length;i++){
            mini =Math.min(mini ,nums[i]);
            maxi = Math.max(maxi ,nums[i]);
        }
        int gcd =1;
        int i =1;
        while(i <=mini){
            if(mini % i==0 && maxi % i==0){
                gcd = i;
            }
            i++;
        }
        return gcd;
    }
}