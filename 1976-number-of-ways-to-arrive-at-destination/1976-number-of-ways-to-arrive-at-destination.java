// class Pair {
//     int dist;
//     int node;

//     public Pair(int dist, int node) {
//         this.dist = dist;
//         this.node = node;
//     }
// }

// class Solution {
//     public int countPaths(int n, int[][] roads) {
//         List<List<Pair>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int j = 0; j < roads.length; j++) {
//             int u = roads[j][0];
//             int v = roads[j][1];
//             int weight = roads[j][2];
//             adj.get(u).add(new Pair(weight, v));
//             adj.get(v).add(new Pair(weight, u));
//         }
//         PriorityQueue<Pair> pq = new PriorityQueue<>(
//                 (a, b) -> Integer.compare(a.dist, b.dist));
//         long dist[] = new long[n];
//         int ways[]=new int[n];
//         Arrays.fill(ways,0);
//         Arrays.fill(dist, Long.MAX_VALUE);
//         dist[0] = 0;
//         ways[0]=1;
//         int mod=(int)(1e9+7);
//         pq.add(new Pair(0, 0));
//         while (!pq.isEmpty()) {
//             Pair cur = pq.poll();
//             int curdist = cur.dist;
//             int node = cur.node;
//            if(curdist>dist[node]){
//             continue;
//            }
//             for (Pair it : adj.get(node)) {
//                 int x = it.node;
//                 int curweight = it.dist;
//                 if (dist[x] > curweight + curdist) {
//                     dist[x] = curweight + curdist;
//                     ways[x]=ways[node];
//                     pq.add(new Pair(curweight + curdist, x));
//                 }else if(dist[x] == curweight + curdist){
//                     ways[x]=(ways[x]+ways[node])%mod;
//                 }
//             }
//         }
//         return ways[n-1];
//     }
// }

class Pair {
    long dist;
    int node;

    public Pair(long dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int weight = road[2];

            adj.get(u).add(new Pair(weight, v));
            adj.get(v).add(new Pair(weight, u));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.dist, b.dist)
        );

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        int mod = (int)(1e9 + 7);

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            long curdist = cur.dist;
            int node = cur.node;

            if (curdist > dist[node]) {
                continue;
            }

            for (Pair it : adj.get(node)) {

                int x = it.node;
                long newDist = curdist + it.dist;

                if (newDist < dist[x]) {

                    dist[x] = newDist;
                    ways[x] = ways[node];

                    pq.add(new Pair(newDist, x));

                } else if (newDist == dist[x]) {

                    ways[x] = (ways[x] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}