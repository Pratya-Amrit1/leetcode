class Tuple {
    int dist;
    int row;
    int col;

    Tuple(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int)1e9);
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);

        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {

            Tuple curr = pq.poll();

            int diff = curr.dist;
            int row = curr.row;
            int col = curr.col;

            if (row == n - 1 && col == m - 1) {
                return diff;
            }
            if (diff > dist[row][col]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

                    int newEffort = Math.max(
                            diff,
                            Math.abs(heights[row][col] - heights[nr][nc])
                    );

                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.add(new Tuple(newEffort, nr, nc));
                    }
                }
            }
        }

        return 0;
    }
}