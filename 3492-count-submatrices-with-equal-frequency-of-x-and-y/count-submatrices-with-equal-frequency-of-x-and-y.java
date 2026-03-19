class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int totalCnt = 0, leftmostX = grid[0].length;
        int[] psum = new int[grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            int cnt = 0;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 'X'){
                    cnt++;
                    //to find the leftmost-x
                    if( j < leftmostX) leftmostX = j;
                }
                else if (grid[i][j] =='Y') cnt--;
                if((psum[j] += cnt) == 0 && j >= leftmostX) ++totalCnt;
            }
        }
        return totalCnt;
    }
}

