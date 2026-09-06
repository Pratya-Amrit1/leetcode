class Solution {
    public int firstStableIndex(int[] nums, int k) {
       int n=nums.length;
        int[] newarr= nums;
        int[] prefix= new int[n];
        int[] sufix=new int[n];
        prefix[0]= newarr[0];
        for(int i=1;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],newarr[i]);
        }
        sufix[n-1]=newarr[n-1];
        for(int i=n-2;i>=0;i--){
            sufix[i]=Math.min(sufix[i+1],newarr[i]);
        }
        for(int i=0;i<n;i++){
            if((long)prefix[i]-sufix[i] <=k){
                return i;
            }
        }
        return -1;
    }
}