class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;

        if(grid[0][0]==1 || grid[n-1][n-1]==1)return -1;

        if(n==1)return 1;

        int[][] dis=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dis[i],(int)1e9);
        }

        Queue<int[]> q =new LinkedList<>();
        dis[0][0]=1;
        q.offer(new int[]{0,0,1});

        int[] dr={-1,-1,0,-1,1,1,0,1};
        int[] dc={0,-1,1,1,0,-1,-1,1};

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int d=curr[2];
            for(int i=0;i<8;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0 && d+1 < dis[nr][nc]){
                    dis[nr][nc]=d+1;

                    if(nr==n-1 && nc==n-1)return d+1;
                    q.offer(new int[]{nr,nc,d+1});
                }
            }
        }
        return -1;
    }
}