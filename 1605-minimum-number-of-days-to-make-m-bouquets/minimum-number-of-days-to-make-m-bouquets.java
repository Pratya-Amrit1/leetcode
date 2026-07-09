class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = Arrays.stream(bloomDay).min().getAsInt(), r = Arrays.stream(bloomDay).max().getAsInt();

        int ans = r;
        int n=bloomDay.length;
        if(n<((long)m*k))return -1;
        while (l <= r) {
            int mid=l+(r-l)/2;
            if(possible(bloomDay,mid,m,k)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    boolean possible(int[] bloomDay, int j,int m,int k){
        int cnt=0;
        int tot=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=j){
                cnt++;
            }
            else{
                tot+=cnt/k;
                cnt=0;
            }
        }
        tot+=cnt/k;
        return tot>= m;
    }
}