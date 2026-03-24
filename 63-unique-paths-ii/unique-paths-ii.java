class Solution {
    public int uniquePathsWithObstacles(int[][] obstacle) {
        int[] prev= new int[obstacle[0].length];
        for(int i=0;i<obstacle.length;i++){
            int[] curr= new int[obstacle[0].length];
            for(int j=0;j<obstacle[0].length;j++){
                if(obstacle[i][j]==1)curr[j]=0;
                else if(i==0 && j==0)curr[j]=1;
                else{
                    int up=0;
                    int left=0;
                    if(i>0) up=prev[j];
                    if(j>0) left= curr[j-1];
                    curr[j]=up+left;
                }
            }
            prev=curr;
        }
        return prev[obstacle[0].length-1];
    }
}