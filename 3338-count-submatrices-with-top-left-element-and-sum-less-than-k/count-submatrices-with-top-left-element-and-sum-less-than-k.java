class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int[][] mem = new int[grid.length][grid[0].length];
        mem[0][0] = grid[0][0];

        int counter = 0;
        if (grid[0][0] <= k)
            counter++;

        for (int i = 1; i < grid.length; ++i) {
            int sum = mem[i - 1][0] + grid[i][0];
            mem[i][0] = sum;
            if (sum <= k)
                counter++;
        }

        for (int j = 1; j < grid[0].length; ++j) {
            int sum = mem[0][j - 1] + grid[0][j];
            mem[0][j] = sum;
            if (sum <= k)
                counter++;
        }

        for (int i = 1; i < grid.length; ++i) {
            for (int j = 1; j < grid[0].length; ++j) {
                int sum = mem[i][j - 1] + (mem[i - 1][j] - mem[i - 1][j - 1]) + grid[i][j];
                mem[i][j] = sum;
                if (sum <= k)
                    counter++;
            }
        }

        return counter;

    }
}