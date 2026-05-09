class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;
        for (int i = 0; i < layers; i++) {
            ArrayList<Integer> val = new ArrayList<>();
            int top = i;
            int left = i;
            int bottom = m - i - 1;
            int right = n - i - 1;

            // top row
            for (int j = left; j <= right; j++) {
                val.add(grid[top][j]);
            }
            // right column
            for (int j = top + 1; j <= bottom - 1; j++) {
                val.add(grid[j][right]);
            }
            // bottom row
            for (int j = right; j >= left; j--) {
                val.add(grid[bottom][j]);
            }
            // left column
            for (int j = bottom - 1; j >= top + 1; j--) {
                val.add(grid[j][left]);
            }
            int sz = val.size();
            int idx = k % sz;
            // top row
            for (int j = left; j <= right; j++) {
                grid[top][j] = val.get(idx);
                idx = (idx + 1) % sz;
            }
            // right column
            for (int j = top + 1; j <= bottom - 1; j++) {
                grid[j][right] = val.get(idx);
                idx = (idx + 1) % sz;
            }
            // bottom row
            for (int j = right; j >= left; j--) {
                grid[bottom][j] = val.get(idx);
                idx = (idx + 1) % sz;
            }
            // left column
            for (int j = bottom - 1; j >= top + 1; j--) {
                grid[j][left] = val.get(idx);
                idx = (idx + 1) % sz;
            }
        }
        return grid;
    }
}