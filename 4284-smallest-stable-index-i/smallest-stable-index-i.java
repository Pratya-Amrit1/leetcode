class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n= nums.length;
        int[] prefix = new int[n];
        int[] sufix= new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],nums[i]);
        }
        sufix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            sufix[i]= Math.min(sufix[i+1],nums[i]);
            
        }
        for(int i=0;i<n;i++){
            long sta =(long)prefix[i]-sufix[i];
            if(sta<=k){
                return i;
            }
        }
        return -1;
    }
}