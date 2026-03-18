class Solution {
    public int countSubmatrices(int[][] mat, int k) {
    int n = mat.length;
    int m = mat[0].length;
    int[][] pre = new int[n][m];
    int c = 0;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            pre[i][j]=mat[i][j];
            if(i!=0)   pre[i][j] += pre[i-1][j];
            if(j!=0)   pre[i][j] += pre[i][j-1];
            if(i!=0 && j!=0)  pre[i][j] -= pre[i-1][j-1];
            if(pre[i][j]<=k)
                c++;
            else
                m=j;
        }
    }
    return c;
    }
}