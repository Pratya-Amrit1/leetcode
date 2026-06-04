class Solution {
    public int minPathSum(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int[][] dp= new int [n][m];
        Arrays.stream(dp).forEach(row-> Arrays.fill(row,-1));

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=grid[0][0];
                }
                else{
                    int up=grid[i][j];
                    if(i>0) up+=dp[i-1][j];
                    else up=Integer.MAX_VALUE;
                    int left =grid[i][j];
                    if(j>0)left+=dp[i][j-1];
                    else left =Integer.MAX_VALUE;
                    dp[i][j]= Math.min(left,up);
                }

            }
        }
        return dp[n-1][m-1];

    }
}