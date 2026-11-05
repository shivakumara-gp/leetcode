class Pair {
    double prob;
    int node;

    public Pair(double prob, int node) {
        this.prob = prob;
        this.node = node;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            double prob = succProb[j];
            adj.get(u).add(new Pair(prob, v));
            adj.get(v).add(new Pair(prob, u));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b.prob, a.prob));
        double dist[] = new double[adj.size()];
        
        dist[start_node] = 1.0;
        pq.add(new Pair(1.0, start_node));

        while (!pq.isEmpty()) {
            Pair cur = pq.remove();
            double curprob = cur.prob;
            int node = cur.node;
             if (curprob < dist[node]) {
                continue;
            }

            if (node == end_node) {
                return curprob;
            }
            for (Pair it : adj.get(node)) {
                int x = it.node;
                double weight = it.prob;
                if (dist[x] < weight * curprob) {
                    dist[x] = weight * curprob;
                    pq.add(new Pair(weight * curprob, x));
                }
            }
        }
        return 0.0;
    }
}