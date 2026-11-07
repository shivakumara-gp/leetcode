class Pair {
    int row, col, dif;

    Pair(int row, int col, int dif) {
        this.row = row;
        this.col = col;
        this.dif = dif;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

       

        int[][] dist = new int[m][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

         PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.dif, b.dif)
        );

        pq.offer(new Pair(0, 0, 0));
        dist[0][0] = 0;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            int row = cur.row;
            int col = cur.col;
            int curdif = cur.dif;
             if (curdif > dist[row][col]) {
                continue;
            }
            if (row == m - 1 && col == n - 1) {
                return curdif;
            }

            for (int i = 0; i < 4; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];
                
                if (nr >= 0 && nc >= 0 &&
                    nr < m && nc < n ) {
                        int nd=Math.abs(heights[nr][nc]-heights[row][col]);
                        int newEffort = Math.max(curdif, nd);
                     if (newEffort < dist[nr][nc]) {

                        dist[nr][nc] = newEffort;

                        pq.offer(new Pair(nr, nc, newEffort));
                    }
                    
                }
            }
        }

       return 0;
    }
}