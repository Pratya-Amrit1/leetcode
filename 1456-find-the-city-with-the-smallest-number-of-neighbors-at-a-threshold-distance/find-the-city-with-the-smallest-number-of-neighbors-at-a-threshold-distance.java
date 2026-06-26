class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis =new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dis[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dis[u][v] = wt;
            dis[v][u] = wt;
    }
        for(int i=0;i<n;i++)dis[i][i]=0;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dis[i][k]==Integer.MAX_VALUE || dis[k][j]==Integer.MAX_VALUE){
                        continue;
                    }
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }
        int city=n;
        int cit=-1;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
               if(dis[i][j]<=distanceThreshold){cnt++;}
            }
            if(cnt<=city){
                city=cnt;
                cit=i;
            }
        }
        return cit;
    }
}