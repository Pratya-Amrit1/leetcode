class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=Arrays.stream(weights).max().getAsInt();
        int right= Arrays.stream(weights).sum();
        int ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(possible(weights,days,mid)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    boolean possible(int[] weights,int days,int cap){
        int tot=0;
        int cnt=1;
        for(int i=0;i<weights.length;i++){
            if(tot+weights[i]<=cap){
                tot+=weights[i];
            }
            else{
                cnt++;
                tot=weights[i];
            }
        }
        return cnt<=days;
    }
}