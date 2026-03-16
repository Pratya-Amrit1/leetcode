class Solution {
    int[] top3 = {-1, -1, -1};

    private void updateTop3(int val) {
        if (val == top3[0] || val == top3[1] || val == top3[2]) return;
        if (val > top3[0]) {
            top3[2] = top3[1]; top3[1] = top3[0]; top3[0] = val;
        } else if (val > top3[1]) {
            top3[2] = top3[1]; top3[1] = val;
        } else if (val > top3[2]) {
            top3[2] = val;
        }
    }

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //creating diagonal for the rhombus
        int[][] diag = new int[m + n][n + 1];
        int[][] antid = new int[m + n][m + 1];
        
        // 1. Build Prefix Sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diag[i - j + n][j + 1] = diag[i - j + n][j] + grid[i][j];
                antid[i + j][i + 1] = antid[i + j][i] + grid[i][j];
            }
        }
        
        // 2. Iterate Centers and Radii
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                updateTop3(grid[i][j]); // d = 0
                
                int max_d = Math.min(Math.min(i, m - 1 - i), Math.min(j, n - 1 - j));
                for (int d = 1; d <= max_d; d++) {
                    int id1 = (i - d) - j + n;
                    int sum1 = diag[id1][j + d] - diag[id1][j];
                    
                    int id2 = i + j + d;
                    int sum2 = antid[id2][i + d] - antid[id2][i];
                    
                    int id3 = i - j + d + n;
                    int sum3 = diag[id3][j + 1] - diag[id3][j - d + 1];
                    
                    int id4 = i + j - d;
                    int sum4 = antid[id4][i + 1] - antid[id4][i - d + 1];
                    
                    updateTop3(sum1 + sum2 + sum3 + sum4);
                }
            }
        }
        
        // 3. Extract Result
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (top3[i] != -1) count++;
        }
        
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = top3[i];
        }
        return res;
    }
}