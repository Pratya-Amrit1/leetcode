class Solution {
    int solve(int i,int j,String s,String t,int[][] dp){
        if(i<0)return j+1;
        if(j<0)return i+1;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]= solve(i-1,j-1,s,t,dp);
        }
        else{ dp[i][j]=Math.min(1+solve(i-1,j-1,s,t,dp),Math.min(1+solve(i-1,j,s,t,dp),1+solve(i,j-1,s,t,dp)));
        }
        return dp[i][j];
    }
    public int minDistance(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp= new int [n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],0);
        }
        
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }
}