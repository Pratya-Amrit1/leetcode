class Solution {

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                // Found a new island
                if (grid[i][j] == '1') {

                    count++;

                    // Visit the complete island
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {

        // Boundary check
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == '0') {
            return;
        }

        // Mark land as visited
        grid[row][col] = '0';

        // Visit up
        dfs(grid, row - 1, col);

        // Visit down
        dfs(grid, row + 1, col);

        // Visit left
        dfs(grid, row, col - 1);

        // Visit right
        dfs(grid, row, col + 1);
    }
}