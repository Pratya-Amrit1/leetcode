class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initcolor= image[sr][sc];
        int[][] ans = image;
        int[] delrow= {-1,0,+1,0};
        int[] delcol= {0,+1,0,-1};
        dfs(initcolor,ans ,delrow , delcol ,image , color,sr,sc);
        return ans;
    }
    private void dfs(int initcolor,int[][] ans , int[] delrow , int[] delcol , int[][] image , int color, int sr ,int sc){
        ans[sr][sc]= color;
        int n= image.length;
        int m= image[0].length;
        for(int i=0;i<4;i++){
            int newrow = sr +delrow[i];
            int newcol = sc+delcol[i];
            if(newrow>=0 && newrow<n && newcol >=0 && newcol<m && image[newrow][newcol]==initcolor && ans[newrow][newcol] !=color){
                dfs(initcolor ,ans ,delrow,delcol ,image ,color ,newrow,newcol);
            }
        }
    }
}