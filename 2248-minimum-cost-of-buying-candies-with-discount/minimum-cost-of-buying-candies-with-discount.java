class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int cnt=0, sum=0;
        int n=cost.length;
        if(n==2)return cost[0]+cost[1];
        if(n==1)return cost[0];
        for(int i=n-1;i>=0;i--){
            sum+=cost[i];
            cnt++;
            if(cnt !=0 && cnt%3==0){
                sum-=cost[i];
            }
        }
        return sum;
    }
}