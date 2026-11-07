class Pair {
    int row, col, dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] != 0 || grid[m-1][n-1] != 0) {
            return -1;
        }

        int[][] dist = new int[m][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, 0, 1));
        dist[0][0] = 1;

        int[] dr = {-1, 0, 0, 1, -1, -1, 1, 1};
        int[] dc = {0, -1, 1, 0, -1, 1, -1, 1};

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            int row = cur.row;
            int col = cur.col;
            int d = cur.dist;

            if (row == m-1 && col == n-1) {
                return d;
            }

            for (int i = 0; i < 8; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nc >= 0 &&
                    nr < m && nc < n &&
                    grid[nr][nc] == 0 &&
                    dist[nr][nc] == Integer.MAX_VALUE) {

                    dist[nr][nc] = d + 1;

                    q.offer(new Pair(nr, nc, d + 1));
                }
            }
        }

        return -1;
    }
}