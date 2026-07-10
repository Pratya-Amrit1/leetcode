class Solution {
        public int smallestDivisor(int[] A, int threshold) {
        int left=1;
        int right= Arrays.stream(A).max().getAsInt();
        int ans=right;
        while(left<=right){
            int mid=(left+right)/2;

            if(possible(A,mid,threshold)){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    boolean possible(int[] A , int k,int check){
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=Math.ceil((double)A[i]/(double)k);
        }
        return sum<=check;
    }
}