class Solution {
    private int first = -1;
    private int second = -1;
    private int third = -1;
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                add(grid[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1;
                     i - k >= 0 && i + k < m && j - k >= 0 && j + k < n;
                     k++) {
                    int sum = 0;
                    for (int d = 0; d < k; d++)
                        sum += grid[i - k + d][j + d];
                    for (int d = 0; d < k; d++)
                        sum += grid[i + d][j + k - d];
                    for (int d = 0; d < k; d++)
                        sum += grid[i + k - d][j - d];
                    for (int d = 0; d < k; d++)
                        sum += grid[i - d][j - k + d];

                    add(sum);
                }
            }
        }
        if (second == -1) return new int[]{first};
        if (third == -1) return new int[]{first, second};
        return new int[]{first, second, third};
    }
    private void add(int val) {
        if (val == first || val == second || val == third) return;
        if (val > first) {
            third = second;
            second = first;
            first = val;
        } 
        else if (val > second) 
        {
            third = second;
            second = val;
        } 
        else if (val > third) 
        {
            third = val;
        }
    }
}