class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int prefixSum[] = new int[n];
        int ans = 0;
        for(int i=0;i<m;i++){
            int currSum = 0;
            for(int j=0;j<n;j++){
                prefixSum[j] = prefixSum[j]+grid[i][j];
                currSum += prefixSum[j];
                if(currSum <= k)ans++;
            }
        }
        return ans;
    }
}