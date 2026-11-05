
class Pair {
    int node;
    int cost;
    int stops;

    Pair(int node, int cost, int stops) {
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int weight = flight[2];

            adj.get(u).add(new Pair(v, weight, 0));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.cost, b.cost)
        );

        int[][] dist = new int[n][k + 2];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[src][0] = 0;
        pq.offer(new Pair(src, 0, 0));

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            int node = cur.node;
            int cost = cur.cost;
            int stops = cur.stops;

            if (cost != dist[node][stops]) {
                continue;
            }

            if (node == dst) {
                return cost;
            }

            if (stops == k + 1) continue;

            for (Pair it : adj.get(node)) {

                int adjNode = it.node;
                int weight = it.cost;

                int newCost = cost + weight;
                int newStops = stops + 1;

                if (newCost < dist[adjNode][newStops]) {

                    dist[adjNode][newStops] = newCost;

                    pq.offer(new Pair(
                        adjNode, newCost, newStops
                    ));
                }
            }
        }

        return -1;
    }
}
